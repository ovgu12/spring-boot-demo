package com.example.boot.cloud.meta;

import java.beans.PropertyEditorSupport;

public class FeigClientMetaPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        var tags = text.split("\\|");
        setValue(FeigClientMeta.builder()
                .name(tags[0])
                .feature(tags[1])
                .build());
    }
}
