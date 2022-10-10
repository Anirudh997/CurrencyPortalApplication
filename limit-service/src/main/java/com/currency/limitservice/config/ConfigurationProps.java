package com.currency.limitservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("limit-service")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationProps {

    private int minimum;
    private int maximum;
}
