package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.mapper.MainMapper;
import com.briup.studentmanage.service.IMainStageService;
import org.springframework.beans.factory.annotation.Autowired;

public class MainStageImpl implements IMainStageService {
    @Autowired
    private MainMapper mainMapper;
    @Override
    public void searchNum() throws RuntimeException {
        mainMapper.sercherNum();
    }
}
