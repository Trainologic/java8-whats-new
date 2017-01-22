package locking;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * @author victorp
 */
abstract public class ChessGame {


    private final List<User> users;

    private LongAdder readCount = new LongAdder();


    private final static long UPDATE_MILLIS = 300;



    abstract <Result> Result  read(User user,Function<User,Result> readUser);
    abstract void update(User user,Consumer<User> updateUser);


    private final ScheduledExecutorService updateExecutor;
    private final ExecutorService readExecutor;

    private CountDownLatch gameCountDown;

    public ChessGame(List<User> users) {
        this.users = users;
        updateExecutor = Executors.newScheduledThreadPool(users.size());
        readExecutor = Executors.newFixedThreadPool(users.size());
    }

    public long getReadCount() {
        return readCount.sum();
    }

    public CountDownLatch playChess(int steps){

        gameCountDown = new CountDownLatch(steps);
        users.forEach(user -> updateExecutor.scheduleWithFixedDelay(() -> doChessStep(user, steps), 10, 500, TimeUnit.MILLISECONDS));

        users.forEach(user -> readExecutor.execute(() -> watchUser(user)));


        return gameCountDown;

    }

    private void watchUser(User user){
        while (gameCountDown.getCount() != 0){
            long theState = read(user, (u) -> u.gameState);

            //print theState
            readCount.increment();
        }


    }


    private void doChessStep(User user,int steps){
        if (user.gameState == steps) return;

        update(user, (u) -> {
            sleep(UPDATE_MILLIS); //simulate chess step calculation
            user.gameState ++;

            if (u.gameState == steps){
                gameCountDown.countDown();
            }
        });
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
