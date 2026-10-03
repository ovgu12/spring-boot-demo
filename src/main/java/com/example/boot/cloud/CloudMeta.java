package com.example.boot.cloud;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CloudMeta {
    private String name;
    private String feature;
}
