package com.example.MunDeuk.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LocationDTO {
    private final Double latitude;      /* 위도 */
    private final Double longitude;     /* 경도 */
}
