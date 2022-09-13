package ru.nikonov.metrics.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nikonov.metrics.entity.Measurement;
import ru.nikonov.metrics.entity.User;
import ru.nikonov.metrics.repository.MeasurementRepository;

@Service
@RequiredArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;


    public Measurement createMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    public Measurement getMeasurement(String id) {
        return measurementRepository.findById(id).get();
    }

    public Measurement changeMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    public List<Measurement> getMeasurements() {
        return measurementRepository.findAll();
    }

    public void deleteMeasurement(String id) {
        measurementRepository.delete(id);
    }
}
