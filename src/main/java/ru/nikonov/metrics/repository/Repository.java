package ru.nikonov.metrics.repository;

import java.util.List;
import java.util.Optional;
import ru.nikonov.metrics.entity.Entity;

public interface Repository<V extends Entity<K>, K> {

    Optional<V> findById(K id);

    List<V> findAll();

    Optional<V> delete(K id);

    V save(V entity);
}
