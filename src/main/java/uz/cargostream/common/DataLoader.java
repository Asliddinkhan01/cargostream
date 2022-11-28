package uz.cargostream.common;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    @Value("${spring.sql.init.mode}")
    private String initialMode;

    @Override
    public void run(String... args) {

    }
}
