package com.ilboogl.certy.service.certificate;

import com.ilboogl.certy.service.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Certificate {
    // TODO add validation
    private Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Long duration;
    private final LocalDateTime createDate;
    private final LocalDateTime lastUpdateDate;

    private final List<Tag> tags;
}
