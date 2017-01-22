package locking;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author victorp
 */
public class ChessGameStampedLock extends ChessGame {
    private final Map<String,StampedLock> stampedLocks;


    public ChessGameStampedLock(List<User> users) {
        super(users);
        stampedLocks = users.stream()
                .collect(Collectors.toMap(User::getName, u -> new StampedLock()));
    }



    @Override
    public String toString() {
        return "ChessGameStampedLock";
    }


    /**
     * Impl using {@link StampedLock}
     */
    @Override
    <Result> Result read(User user,Function<User,Result> readUser) {
        throw new NotImplementedException();
    }


    /**
     * Impl using {@link StampedLock}
     */
    @Override
    void update(User user, Consumer<User> updateUser) {
        throw new NotImplementedException();
    }


}
