package com.ex.repository;

import com.ex.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryWiseSayingRepository implements WiseSayingRepository{
    private final List<WiseSaying> wiseSayings;
    private Long id;

    public MemoryWiseSayingRepository() {
        this.wiseSayings = new ArrayList<>();
        this.id = 1L;
    }

    @Override
    public Long save(WiseSaying wiseSaying) {
        wiseSaying.setId(id);
        wiseSayings.add(wiseSaying);
        return this.id++;
    }

    @Override
    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    @Override
    public boolean deleteById(int id) {
        // 인덱스 범위 검사
        if(id < 0 || id >  wiseSayings.size()){
            return false;
        }

         for(int i=0;i<wiseSayings.size();i++){
             WiseSaying cur = wiseSayings.get(i);
             if(cur.getId() == id){
                 wiseSayings.remove(i);
                 return true;
             }
         }

        return false;
    }
}
