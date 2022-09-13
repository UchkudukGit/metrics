package ru.nikonov.metrics.entity;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Entity<UUID> {

    private UUID id;
    private String login;
    private String password;
    private String name;
}
