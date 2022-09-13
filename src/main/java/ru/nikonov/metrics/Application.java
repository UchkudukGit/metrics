package ru.nikonov.metrics;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.nikonov.metrics.entity.Measurement;
import ru.nikonov.metrics.entity.User;
import ru.nikonov.metrics.repository.MeasurementRepository;
import ru.nikonov.metrics.repository.UserRepository;

@SpringBootApplication
@Slf4j
public class Application implements ApplicationRunner {

    @Autowired
    MeasurementRepository measurementRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createMeasurements();
        log.info("swagger http://localhost:8080/swagger-ui/");
    }

    private void createMeasurements(){
        Measurement millimetre = new Measurement();
        millimetre.setId("mm");
        millimetre.setName("millimetre");
        Measurement meter = new Measurement();
        meter.setId("m");
        meter.setName("meter");
        measurementRepository.saveAll(List.of(millimetre, meter));
    }
}
