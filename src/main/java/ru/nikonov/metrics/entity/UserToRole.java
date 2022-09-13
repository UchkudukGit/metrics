package ru.nikonov.metrics.entity;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserToRole implements Entity<UUID>{

    private UUID id;
    private UUID userId;
    private String role;

}
