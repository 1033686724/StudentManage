package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.Notice;

import java.util.List;

public interface IMainStageService {
    String[] searchNum()throws RuntimeException;
    List<Notice> show()throws RuntimeException;
}
