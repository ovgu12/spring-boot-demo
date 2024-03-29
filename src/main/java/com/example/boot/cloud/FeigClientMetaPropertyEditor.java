package com.example.boot.cloud;

import java.beans.PropertyEditorSupport;

public class FeigClientMetaPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        var tags = text.split("\\|");
        setValue(FeigClientMeta.builder().name(tags[0]).build());
    }
}
