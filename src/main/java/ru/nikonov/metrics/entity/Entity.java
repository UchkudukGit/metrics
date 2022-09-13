package ru.nikonov.metrics.entity;

public interface Entity<K> {

    K getId();

    void setId(K key);
}
