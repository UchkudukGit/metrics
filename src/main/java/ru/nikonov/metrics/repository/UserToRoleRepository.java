package ru.nikonov.metrics.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Component;
import ru.nikonov.metrics.entity.User;
import ru.nikonov.metrics.entity.UserToRole;

@Component
public class UserToRoleRepository extends AbstractRepository<UserToRole, UUID> {

    private static Map<UUID, UserToRole> map = new HashMap<>();

    @Override
    protected Map<UUID, UserToRole> getMap() {
        return map;
    }

    @Override
    protected void generateId(UserToRole user) {
       user.setId(UUID.randomUUID());
    }
}
