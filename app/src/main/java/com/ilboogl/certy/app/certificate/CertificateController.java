package com.ilboogl.certy.app.certificate;

import com.ilboogl.certy.service.certificate.Certificate;
import com.ilboogl.certy.service.certificate.CertificateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateUseCase certificateUseCase;

    @Autowired
    CertificateController(CertificateUseCase certificateUseCase) {
        this.certificateUseCase = certificateUseCase;
    }

    @GetMapping("/")
    public Certificate getCertificate1() {
        return new Certificate("1", "1", BigDecimal.ONE, 1L, now(), now());
    }

    @GetMapping("/{id}")
    public Certificate getCertificate(@PathVariable Long id) {
        return new Certificate("1", "1", BigDecimal.ONE, 1L, now(), now());
    }

}
