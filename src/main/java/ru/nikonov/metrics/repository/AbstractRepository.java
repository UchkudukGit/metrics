package ru.nikonov.metrics.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import ru.nikonov.metrics.entity.Entity;

public abstract class AbstractRepository<V extends Entity<K>, K> implements Repository<V, K> {

    public Optional<V> findById(K id) {
        return Optional.ofNullable(getMap().get(id));
    }

    public List<V> findAll() {
        return new ArrayList<>(getMap().values());
    }

    public Optional<V> delete(K id) {
        return Optional.ofNullable(getMap().remove(id));
    }

    public V save(V entry) {
        if (Objects.isNull(entry.getId())) {
            generateId(entry);
        }
        getMap().put(entry.getId(), entry);
        return entry;
    }

    public List<V> saveAll(Collection<V> entryList) {
        List<V> savedEntryList = new ArrayList<>();
        for (V entry : entryList) {
            if (Objects.isNull(entry.getId())) {
                generateId(entry);
            }
            getMap().put(entry.getId(), entry);
            savedEntryList.add(entry);
        }
        return savedEntryList;
    }

    abstract protected Map<K, V> getMap();

    abstract protected void generateId(V entry);
}
