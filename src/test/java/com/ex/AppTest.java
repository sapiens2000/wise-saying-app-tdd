package com.ex;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {


    @DisplayName("1단계 테스트")
    @Test
    void step1(){
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        App.run();
        assertThat(output.toString())
                .contains("== 명언 앱 ==")
                .contains("명령) ");

        TestUtil.clearSetOutToByteArray(output);
    }
}