package com.ex;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.run(new Scanner(System.in));
    }

    public void run(Scanner sc){
        System.out.println("== 명언 앱 ==");

        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = sc.nextLine();

                System.out.print("작가 : ");
                String author = sc.nextLine();
            }
            else if(cmd.equals("종료")){
                break;
            }
        }

    }
}