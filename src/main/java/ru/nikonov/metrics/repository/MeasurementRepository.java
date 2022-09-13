package ru.nikonov.metrics.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Component;
import ru.nikonov.metrics.entity.Measurement;
import ru.nikonov.metrics.entity.User;

@Component
public class MeasurementRepository extends AbstractRepository<Measurement, String> {

    private static Map<String, Measurement> map = new HashMap<>();

    @Override
    protected Map<String, Measurement> getMap() {
        return map;
    }

    @Override
    protected void generateId(Measurement entry) {
        throw new UnsupportedOperationException();
    }
}
