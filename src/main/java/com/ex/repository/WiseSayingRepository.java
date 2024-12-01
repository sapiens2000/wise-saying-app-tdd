package com.ex.repository;

import com.ex.WiseSaying;

import java.util.List;

public interface WiseSayingRepository {


    Long save(WiseSaying wiseSaying);
    List<WiseSaying> findAll();
    boolean deleteById(int idx);
}
