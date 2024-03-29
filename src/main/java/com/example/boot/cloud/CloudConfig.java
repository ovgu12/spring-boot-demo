package com.example.boot.cloud;

import com.example.boot.cloud.meta.FeigClientMeta;
import com.example.boot.cloud.meta.FeigClientMetaPropertyEditor;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudConfig {

    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        var custom = new CustomEditorConfigurer();
        custom.setCustomEditors(Map.of(FeigClientMeta.class, FeigClientMetaPropertyEditor.class));
        return custom;
    }
}
