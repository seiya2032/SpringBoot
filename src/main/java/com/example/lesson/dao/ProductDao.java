package com.example.lesson.dao;

import com.example.lesson.record.ProductRecord;
import java.awt.*;

import java.util.List;

public interface ProductDao {

    // レコードの情報をすべて表示
    public List<ProductRecord> findAll();

    //　ID検索特定の情報を閲覧
    public ProductRecord findById(int id);

    // インサート　レコードを増やす
    public int insert (ProductRecord user);

    // アップデート　値のデータを変更する
    public int update(ProductRecord id);

    // デリート　カラムの消去
    public int delete(int id);
}
