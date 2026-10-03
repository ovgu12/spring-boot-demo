package com.example.boot.cloud;

import java.beans.PropertyEditorSupport;

public class CloudMetaPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        var tags = text.split("\\|");
        setValue(CloudMeta.builder()
                .name(tags[0])
                .feature(tags[1])
                .build());
    }
}
