package com.ex;

import com.ex.controller.WiseSayingController;
import com.ex.repository.MemoryWiseSayingRepository;
import com.ex.repository.WiseSayingRepository;
import com.ex.service.WiseSayingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.run(new Scanner(System.in));
    }

    public void run(Scanner sc){
        WiseSayingRepository wiseSayingRepository = new MemoryWiseSayingRepository();
        WiseSayingService wiseSayingService = new WiseSayingService(wiseSayingRepository);
        WiseSayingController wiseSayingController = new WiseSayingController(wiseSayingService, sc);

        wiseSayingController.init();
    }
}