package com.ilboogl.certy.service.certificate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Certificate {
    private Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Long duration;
    private final LocalDateTime createDate;
    private final LocalDateTime lastUpdateDate;
}
