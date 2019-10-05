package net.mossol.oc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication(
		scanBasePackages = {"net.mossol"},
		scanBasePackageClasses = {Jsr310JpaConverters.class})
public class OcApplication {

    public static void main(String[] args) {
		SpringApplication.run(OcApplication.class, args);
	}

}
