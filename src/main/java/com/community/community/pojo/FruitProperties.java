package com.community.community.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties("fruit")
@Component
public class FruitProperties {
    private String colorName;
}
