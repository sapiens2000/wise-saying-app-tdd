package com.ex;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;


import static org.assertj.core.api.Assertions.assertThat;

class AppTest {
    @DisplayName("1단계 테스트")
    @Test
    void step1() {
        Scanner sc = TestUtil.genScanner("종료");
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        App app = new App();
        app.run(sc);

        assertThat(output.toString())
                .contains("== 명언 앱 ==")
                .contains("명령) ");

        TestUtil.clearSetOutToByteArray(output);
    }

    @DisplayName("2단계 테스트")
    @Test
    void step2() {
        String cmd = """
                등록
                현재를 사랑하라.
                작자미상
                종료
                """;

        Scanner sc = TestUtil.genScanner(cmd);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();


        App app = new App();
        app.run(sc);

        assertThat(output.toString())
                .contains("명언 : ")
                .contains("작가 : ");

        TestUtil.clearSetOutToByteArray(output);
    }
}