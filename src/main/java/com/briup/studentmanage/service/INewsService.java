package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.ManagerAdminKey;
import com.briup.studentmanage.bean.News;

import java.util.List;

public interface INewsService {
    List<News> search(String word)throws  RuntimeException;
}
