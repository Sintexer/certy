package com.ilboogl.certy.service.tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Tag {
    private Long id;
    private final String name;
}
