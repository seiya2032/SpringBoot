package com.example.lesson.service;

import com.example.lesson.dao.ProductDao;
import com.example.lesson.record.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PgProductService implements ProductService{

    @Autowired
    // ProductDaoのインスタンスを取得している
    public ProductDao productDao;

    @Override
    // Daoクラスから来たデータを取得している
    public List<ProductRecord> findAll() {
        return productDao.findAll();
    }

    @Override
    // Daoクラスから来たID検索の処理を受け取っている
    public ProductRecord findById(int id) {
        return productDao.findById(id);
    }

    @Override
    // Daoクラスからきた処理を受け取り実行クラスにリターンしている
    public int insert(ProductRecord user) {
        return productDao.insert(user);
    }

    @Override
    // 実行クラスから渡された変更データをDaoクラスに渡している
    public int update(ProductRecord id) {
        return productDao.update(id);
    }

    @Override
    public int delete(int id) {
        // 実行クラスから渡されたIDをDaoクラスに渡している
        return productDao.delete(id);
    }
}
