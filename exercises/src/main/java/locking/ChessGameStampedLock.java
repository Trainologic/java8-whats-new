package locking;

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

    <Result> Result readWithSpin(User user,Function<User,Result> readUser) {
        StampedLock lock = stampedLocks.get(user.getName());
        long stamp = lock.tryOptimisticRead();

        Result result;
        do {
            result = readUser.apply(user);
        }while(!lock.validate(stamp));

        return result;

    }

    @Override
    <Result> Result read(User user,Function<User,Result> readUser) {
        return readWithoutSpin(user,readUser);
    }


    <Result> Result readWithoutSpin(User user,Function<User,Result> readUser) {
        StampedLock lock = stampedLocks.get(user.getName());
        long stamp = lock.tryOptimisticRead();
        Result result = readUser.apply(user);
        if (!lock.validate(stamp)) {
            Lock readLock = lock.asReadLock();
            readLock.lock();
            try {
                result = readUser.apply(user);
            }finally {
                readLock.unlock();
            }
        }
        return result;
    }

    @Override
    void update(User user, Consumer<User> updateUser) {

        StampedLock lock = stampedLocks.get(user.getName());
        Lock writeLock = lock.asReadWriteLock().writeLock();
        writeLock.lock();
        try
        {
            updateUser.accept(user);
        }finally {
            writeLock.unlock();
        }

    }


}
