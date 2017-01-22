package locking;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import javafx.util.Pair;
import org.junit.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author victorp
 */
public class GamesTest {


    /**
     * Result when running on i5 CPU (4 cored)
     *
     *     int warmUpTimes = 5;
     *     int times = 5;
     *     int chessSteps = 5;
     *
     * ChessGameSync total time millis: 4943
     * ChessGameSync read/sec: 136066
     * ChessGameRWLock total time millis: 5350
     * ChessGameRWLock read/sec: 63231
     * ChessGameStampedLock total time millis: 5161
     * ChessGameStampedLock read/sec: 257797
     */


    int warmUpTimes = 2;
    int times = 2;
    int chessSteps = 5;

    private List<User> users() {
        return IntStream.range(1, 100)
                .mapToObj(index -> new User("user-" + index, index % 50, 0))
                .collect(Collectors.toList());
    }


    public long chessSimulation(ChessGame game) throws InterruptedException {
        long startTimestamp = System.currentTimeMillis();
        game.playChess(chessSteps).await();
        long endTimestamp = System.currentTimeMillis();
        return endTimestamp - startTimestamp;
    }

    @Test
    public void chessSimulationSync() throws InterruptedException {
        chessSimulation(ChessGameSync::new,"ChessGameSync");
    }

    @Test
    public void chessSimulationRWLock() throws InterruptedException {
        chessSimulation(ChessGameRWLock::new,"ChessGameRWLock");
    }

    @Test
    public void chessSimulationStamped() throws InterruptedException {
        chessSimulation(ChessGameStampedLock::new,"ChessGameStampedLock");
    }




    public void chessSimulation(Function<List<User>,ChessGame> ChessGameConstructor, String name) throws InterruptedException {
        runMultiple(warmUpTimes,ChessGameConstructor);
        Pair<Long,Long> avgs = runMultiple(times,ChessGameConstructor);
        Util.println(name+" total time millis: "+avgs.getKey());
        Util.println(name+" read/sec: "+avgs.getValue()/avgs.getKey());

    }

    private Pair<Long,Long> runMultiple(int iter,Function<List<User>,ChessGame> ChessGameConstructor) throws InterruptedException {
        long avgTime = 0;
        long avgReadCount = 0;
        for (int i = 0 ; i< iter; i++) {
            List<User> users = users();
            ChessGame game = ChessGameConstructor.apply(users);
            avgTime += chessSimulation(game);
            avgReadCount += game.getReadCount();
        }
        return new Pair<>(avgTime/iter,avgReadCount/iter);
    }


}
