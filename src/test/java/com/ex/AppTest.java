package com.ex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    @DisplayName("1단계 테스트")
    @Test
    void step1(){
        App.run();
    }
}