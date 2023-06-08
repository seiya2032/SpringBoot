package com.example.lesson.service;

//import com.example.lesson.controller.TestController.User;
import com.example.lesson.dao.TestDao;
import com.example.lesson.record.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    public int insert(ProductForm form) {
//        // フォームクラスから必要なデータを取得
//        String name = form.getProduct_name();
//        int price = form.getPrice();
//
//        return testDao.insert(name, price);
//    }

    public int insert(String name, int price) {
        Integer id = null;

        ProductRecord record = new ProductRecord(null, name, price);

        return testDao.insert(record);
    }

    public int update(Integer id, String name, int price) {

            ProductRecord record = new ProductRecord(id, name, price);
        return testDao.update(record);
    }

    public int delete(Integer id) {
        // 実行クラスから渡されたIDをDaoクラスに渡している
        return testDao.delete(id);
    }
}
