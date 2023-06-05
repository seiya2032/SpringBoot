package com.example.lesson.service;

//import com.example.lesson.controller.TestController.User;
import com.example.lesson.dao.ProductDao;
import com.example.lesson.dao.TestDao;
import com.example.lesson.record.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class TestService {

    @Autowired
    // Daoのインスタンスを取得している
    public TestDao testDao;

    public List<ProductRecord> findAll() {
        return testDao.findAll();
    }

    public ProductRecord findById(int id) {
        return testDao.findById(id);
    }

}
