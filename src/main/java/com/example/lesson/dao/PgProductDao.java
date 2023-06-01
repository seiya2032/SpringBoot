package com.example.lesson.dao;

import com.example.lesson.record.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PgProductDao implements ProductDao{

    @Autowired
    // DBの接続するために必要な物（JDBCを使用するための基本的な機能を提供している）
    // private JdbcTemplate jdbcTemplate;
    // プレースホルダーを使用するためには「NamedParameterJdbcTemplate」クラスを使う必要があります。
    private NamedParameterJdbcTemplate jdbcTemplate;

    // インターフェースクラスのfindAll()メソッドを上書きしている
    @Override
    public List<ProductRecord> findAll() {
        // SQL文を作成している
        return jdbcTemplate.query("SELECT * FROM products ",
                // DBからの結果をProductRecordクラスの値に入れている
                new DataClassRowMapper<>(ProductRecord.class));
    }

    @Override
    public ProductRecord findById (int id) {
        // オブジェクト　paramを作成
        MapSqlParameterSource param = new MapSqlParameterSource();
        // paramオブジェクトにid（名前）id（値）を追加しています
        param.addValue("id", id);
        // SQL文を作りクリエを実行　DBで処理をしている
        var list = jdbcTemplate.query("SELECT * FROM products WHERE id = :id", param, new DataClassRowMapper<>(ProductRecord.class));
        // リストの中身がなければnullをそうでなければ中身の値をリターンでサービスクラスに渡します
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int insert(ProductRecord user) {
        //　オブジェクト　paramを作成
        MapSqlParameterSource param = new MapSqlParameterSource();
        // paramオブジェクトに""（名前）（値）を追加しています
        param.addValue("id", user.id());
        param.addValue("name", user.name());
        param.addValue("price", user.price());
        // SQLのクリエをDBで実行　
        return jdbcTemplate.update("INSERT INTO products VALUES(:id, :name, :price)",param);
    }

    @Override
    public int update(ProductRecord id) {
        // オブジェクト　paramを作成
        MapSqlParameterSource param = new MapSqlParameterSource();
        // paramオブジェクトに""（名前）（値）を追加しています
        param.addValue("id", id.id());
        param.addValue("name", id.name());
        param.addValue("price", id.price());
        // SQLのクリエをDBで実行
        return jdbcTemplate.update("UPDATE products SET name = :name, price = :price WHERE id = :id", param);
    }

    @Override
    public int delete(int id) {
        // オブジェクト　paramを作成
        MapSqlParameterSource param = new MapSqlParameterSource();
        // paramオブジェクトに""（名前）（値）を追加しています
        param.addValue("id", id);
        // SQLのクリエをDBで実行
        return jdbcTemplate.update("DELETE FROM products WHERE id = :id;", param);
    }
}
