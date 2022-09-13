package ru.nikonov.metrics.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Measurement implements Entity<String>{

    String name;

    String id;

}
