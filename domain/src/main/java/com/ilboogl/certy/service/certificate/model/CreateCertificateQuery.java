package com.ilboogl.certy.service.certificate.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class CreateCertificateQuery {

    @NotBlank(message = "certificate.create.error.name.blank")
    private final String name;

    @NotBlank(message = "certificate.create.error.description.blank")
    private final String description;

    @Valid
    @NotNull
    private final Price price;

    @Min(value = 1, message = "certificate.create.error.duration")
    private long duration;
}
