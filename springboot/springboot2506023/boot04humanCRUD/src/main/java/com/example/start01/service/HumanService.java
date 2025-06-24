package com.example.start01.service;

import com.example.start01.dao.HumanDao;
import com.example.start01.dto.HumanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HumanService {
    @Autowired
    private HumanDao humanDao;

    public void humanInsert(HumanDto humanDto){
        humanDao.humanInsert(humanDto);
    }

    public ArrayList<HumanDto> selectAll() {
        return humanDao.humanSelectAll();
    }

    public HumanDto humanSelectName(String name){
        return humanDao.humanSelectName(name);
    }

    public void humanUpdate(HumanDto humanDto){
        humanDao.humanUpdate(humanDto);
    }

    public void humanDelete(String name) {
        humanDao.humanDelete(name);
    }
}
