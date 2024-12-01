package com.ex.service;

import com.ex.WiseSaying;
import com.ex.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService(WiseSayingRepository wiseSayingRepository) {
        this.wiseSayingRepository = wiseSayingRepository;
    }

    public Long add(String content, String author){
        return wiseSayingRepository.save(new WiseSaying(author, content));
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public boolean deleteById(int idx) {
        return wiseSayingRepository.deleteById(idx);
    }
}
