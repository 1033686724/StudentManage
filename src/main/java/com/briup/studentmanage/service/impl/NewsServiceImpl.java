package com.briup.studentmanage.service.impl;


import com.briup.studentmanage.bean.News;
import com.briup.studentmanage.service.INewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {

    @Override
    public List<News> search(String word) throws RuntimeException {
        return null;
    }
}
