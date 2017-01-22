package locking;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author victorp
 */
public class ChessGameRWLock  extends ChessGame{
    private final Map<String,ReadWriteLock> rwLocks;

    public ChessGameRWLock(List<User> users) {
        super(users);
        rwLocks = users.stream()
                .collect(Collectors.toMap(User::getName, u -> new ReentrantReadWriteLock()));
    }


    @Override
     <Result> Result read(User user,Function<User,Result> readUser) {
        ReadWriteLock lock = rwLocks.get(user.getName());
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            return readUser.apply(user);
        }finally {
            readLock.unlock();
        }
    }

    @Override
    void update(User user,Consumer<User> updateUser) {
        ReadWriteLock lock = rwLocks.get(user.getName());
        Lock writeLock = lock.writeLock();
        writeLock.lock();
        try
        {
            updateUser.accept(user);
        }finally {
            writeLock.unlock();
        }
    }
}
