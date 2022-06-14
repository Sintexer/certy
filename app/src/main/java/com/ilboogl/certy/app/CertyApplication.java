package com.ilboogl.certy.app;

import com.ilboogl.certy.service.ServiceComponentScanMarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {ServiceComponentScanMarker.class, CertyApplication.class})
public class CertyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CertyApplication.class, args);
    }
}
