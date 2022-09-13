package ru.nikonov.metrics.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;
import ru.nikonov.metrics.entity.User;

@Component
public class UserRepository extends AbstractRepository<User, UUID> {

    private static Map<UUID, User> map = new HashMap<>();
//    private static Integer counter = 1;

    public Optional<User> findByLogin(String login) {
        return map.values().stream()
            .filter(user -> Objects.equals(user.getLogin(), login))
            .findFirst();
    }

    @Override
    protected Map<UUID, User> getMap() {
        return map;
    }

    @Override
    protected void generateId(User user) {
        user.setId(UUID.randomUUID());
    }
}
