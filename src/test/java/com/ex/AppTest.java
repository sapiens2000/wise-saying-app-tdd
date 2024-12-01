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

    @DisplayName("3단계 테스트")
    @Test
    void step3(){
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
                .contains("작가 : ")
                .contains("1번 명언이 등록되었습니다.");

        TestUtil.clearSetOutToByteArray(output);
    }

    @DisplayName("4단계 테스트")
    @Test
    void step4(){
        String cmd = """
                등록
                현재를 사랑하라.
                작자미상
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
                .contains("작가 : ")
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.");

        TestUtil.clearSetOutToByteArray(output);
    }

    @DisplayName("5단계 테스트")
    @Test
    void step5(){
        String cmd = """
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                목록
                종료
                """;

        Scanner sc = TestUtil.genScanner(cmd);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        App app = new App();
        app.run(sc);

        assertThat(output.toString())
                .contains("번호 / 작가 / 명언")
                .contains("----------------------")
                .contains("2 / 작자미상 / 과거에 집착하지 마라.")
                .contains("1 / 작자미상 / 현재를 사랑하라.");

        TestUtil.clearSetOutToByteArray(output);
    }
}