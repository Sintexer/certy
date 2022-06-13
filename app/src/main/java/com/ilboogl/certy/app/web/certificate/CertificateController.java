package com.ilboogl.certy.app.web.certificate;

import com.ilboogl.certy.service.certificate.Certificate;
import com.ilboogl.certy.service.certificate.CertificateUseCase;
import com.ilboogl.certy.service.certificate.model.CreateCertificateQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(path = {"", "/"})
    public Certificate createCertificate(@RequestBody @Validated @Valid CreateCertificateQuery createQuery, BindingResult result) {
        System.out.println(createQuery);
        System.out.println(result);
        certificateUseCase.create(createQuery);
        return null;
    }

    @GetMapping("/")
    public Certificate getAllCertificates() {
        return null;
    }

    @GetMapping("/{id}")
    public Certificate getCertificate(@PathVariable Long id) {
        return null;
    }

}
