package ru.nikonov.metrics.controller;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nikonov.metrics.entity.Measurement;
import ru.nikonov.metrics.entity.User;
import ru.nikonov.metrics.service.MeasurementService;
import ru.nikonov.metrics.service.UserService;

@RestController
@RequestMapping("api/v1/measurements")
@RequiredArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;

    @PostMapping
    Measurement createMeasurement(@RequestBody Measurement measurement) {
        return measurementService.createMeasurement(measurement);
    }

    @GetMapping("/{measurementId}")
    Measurement getMeasurement(@PathVariable("measurementId") String id) {
        return measurementService.getMeasurement(id);
    }

    @PutMapping
    Measurement changeMeasurement(@RequestBody Measurement measurement) {
        return measurementService.changeMeasurement(measurement);
    }

    @GetMapping
    List<Measurement> getMeasurements() {
        return measurementService.getMeasurements();
    }

    @DeleteMapping("/{measurementId}")
    void deleteMeasurement(@PathVariable("measurementId") String id) {
        measurementService.deleteMeasurement(id);
    }
}
