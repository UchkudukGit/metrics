package ru.nikonov.metrics.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Component;
import ru.nikonov.metrics.entity.Role;
import ru.nikonov.metrics.entity.UserToRole;

@Component
public class RoleRepository extends AbstractRepository<Role, UUID> {

    private static Map<UUID, Role> map = new HashMap<>();

    @Override
    protected Map<UUID, Role> getMap() {
        return map;
    }

    @Override
    protected void generateId(Role user) {
       user.setId(UUID.randomUUID());
    }
}
