package com.ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.run(new Scanner(System.in));
    }

    public void run(Scanner sc){
        System.out.println("== 명언 앱 ==");

        Long id = 1L;
        List<WiseSaying> wiseSayings = new ArrayList<>();

        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if(cmd.equals("종료")){
                break;
            }
            else if(cmd.startsWith("삭제?")){
                int idx = Integer.parseInt(cmd.split("=")[1]);
                if(wiseSayings.get(idx) != null){
                    wiseSayings.remove(idx);
                    System.out.println(idx + "번 명언이 삭제되었습니다.");
                }
            }
            else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(WiseSaying cur : wiseSayings.reversed()){
                    System.out.println(cur);
                }
            }

            else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = sc.nextLine();

                System.out.print("작가 : ");
                String author = sc.nextLine();

                // 유효성 검증하기
                
                wiseSayings.add(new WiseSaying(id, wiseSaying, author));
                System.out.println(id++ + "번 명언이 등록되었습니다.");
            }

        }

    }
}