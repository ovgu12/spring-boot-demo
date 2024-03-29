package com.example.boot.common.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TrimAttributeConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String title) {
        return title.trim();
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData.trim();
    }
}
