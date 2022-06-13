package com.ilboogl.certy.service.certificate.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateCertificateQuery {
    private final String name;
    private final String description;
    private final Price price;
}
