package com.example.boot.cloud.meta;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FeigClientMeta {
    private String name;
    private String feature;
}
