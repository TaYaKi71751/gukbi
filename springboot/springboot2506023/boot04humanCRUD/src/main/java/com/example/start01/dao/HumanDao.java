package com.example.start01.dao;

import com.example.start01.dto.HumanDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface HumanDao {
    void humanInsert(HumanDto humanDto);

    ArrayList<HumanDto> humanSelectAll();

    HumanDto humanSelectName(String name);



    void humanUpdate(HumanDto humanDto);

    void humanDelete(String name);
}

