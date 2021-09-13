package com.community.community.pojo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FruitPropertiesTest {

    @Autowired
    FruitProperties fp;

    @Test
    public void colorName() {

        Assertions.assertThat(fp.getColorName()).isEqualTo("blue");

    }
}