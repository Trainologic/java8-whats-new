package locking;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author victorp
 */
public class ChessGameSync extends ChessGame {
    private final Map<String,Object> syncs;

    public ChessGameSync(List<User> users) {
        super(users);
        syncs = users.stream()
                .collect(Collectors.toMap(User::getName, u -> new Object()));
    }

    @Override
    public String toString() {
        return "ChessGameSync";
    }

    @Override
    <Result> Result read(User user,Function<User,Result> readUser) {
        synchronized (syncs.get(user.getName())){
            return readUser.apply(user);
        }
    }

    @Override
    void update(User user,Consumer<User> updateUser) {
        synchronized (syncs.get(user.getName())){
            updateUser.accept(user);
        }
    }
}
