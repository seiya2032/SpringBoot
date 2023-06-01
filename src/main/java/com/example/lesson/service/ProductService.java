package com.example.lesson.service;

import com.example.lesson.record.ProductRecord;

import java.util.List;

public interface ProductService {

    // レコードの情報をすべて表示
    // 上書きされて来た実行結果を実行クラスに渡している
    public List<ProductRecord> findAll();

    // ID検索
    public ProductRecord findById(int id);

    // インサート
    public int insert(ProductRecord user);

    // アップデート
    public int update(ProductRecord id);

    // デリートの処理
    public int delete(int id);
}
