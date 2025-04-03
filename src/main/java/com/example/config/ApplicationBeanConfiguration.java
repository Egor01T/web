package com.example.config;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.validation.Validation;
import jakarta.validation.Validator;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public Validator validator(){
        return Validation
            .buildDefaultValidatorFactory()
            .getValidator();
    }

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        // Настройка для корректного маппинга приватных полей
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        // Конвертер из String в ZonedDateTime
        Converter<String, ZonedDateTime> stringToZonedDateTime = new AbstractConverter<>() {
            @Override
            protected ZonedDateTime convert(String source) {
                if (source == null) return null;
                return ZonedDateTime.parse(source, DateTimeFormatter.ISO_ZONED_DATE_TIME);
            }
        };

        // Конвертер из ZonedDateTime в String
        Converter<ZonedDateTime, String> zonedDateTimeToString = new AbstractConverter<>() {
            @Override
            protected String convert(ZonedDateTime source) {
                if (source == null) return null;
                return source.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
            }
        };

        // Регистрация конвертеров
        modelMapper.addConverter(stringToZonedDateTime);
        modelMapper.addConverter(zonedDateTimeToString);

        return modelMapper;
    }
}
