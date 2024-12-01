package com.ex.controller;

import com.ex.WiseSaying;
import com.ex.service.WiseSayingService;

import java.util.Scanner;

public class WiseSayingController {
    private final WiseSayingService wiseSayingService;
    private final Scanner sc;

    public WiseSayingController(WiseSayingService wiseSayingService, Scanner sc) {
        this.wiseSayingService = wiseSayingService;
        this.sc = sc;
    }

    public void init(){
        System.out.println("== 명언 앱 ==");

        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if(cmd.equals("종료")) break;
            else if(cmd.startsWith("삭제?")) delete(cmd);
            else if(cmd.equals("목록")) showList();
            else if (cmd.equals("등록")) register();
        }
    }

    private void register(){
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        // 유효성 검증하기
        Long id = wiseSayingService.add(author, content);
        System.out.println(id++ + "번 명언이 등록되었습니다.");
    }

    private void showList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(WiseSaying cur : wiseSayingService.findAll().reversed()){
            System.out.println(cur);
        }
    }

    private void delete(String cmd){
        int id = Integer.parseInt(cmd.split("=")[1]);
        if(wiseSayingService.deleteById(id)){
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }else{
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }
}
