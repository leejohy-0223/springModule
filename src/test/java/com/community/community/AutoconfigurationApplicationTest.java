package com.community.community;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AutoconfigurationApplicationTest {

    @Value("${property.test.name}")
    private String propertyTestName;

    @Test
    public void testValue() {
        System.out.println(propertyTestName);
        Assertions.assertThat(propertyTestName).isEqualTo("property depth test");
    }
}
