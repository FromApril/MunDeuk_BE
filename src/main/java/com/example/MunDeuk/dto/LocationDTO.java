package com.example.MunDeuk.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LocationDTO {
    private final String latitude;      /* 위도 */
    private final String longitude;     /* 경도 */
}
