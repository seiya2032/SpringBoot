package com.example.lesson.dao;

import com.example.lesson.controller.TestController;
import com.example.lesson.record.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// import static com.sun.tools.javac.tree.TreeInfo.name;
// import static org.springframework.web.servlet.function.RequestPredicates.param;

@Repository
public class TestDao {

    // DBの接続するために必要な物（JDBCを使用するための基本的な機能を提供している）
    @Autowired
//    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate jdbcTemplate;


    public List<ProductRecord> findAll() {
        // SQL文を作成している
        return jdbcTemplate.query("SELECT * FROM products ",
                // DBからの結果をProductRecordクラスの値に入れている
                new DataClassRowMapper<>(ProductRecord.class));
    }

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

    public int insert(ProductRecord record) {
        //　オブジェクト　paramを作成
        MapSqlParameterSource param = new MapSqlParameterSource();
        // paramオブジェクトに""（名前）（値段）を追加しています
        param.addValue("name", record.name());
        param.addValue("price", record.price());
        System.out.println("insert");
        // SQLのクリエをDBで実行　
        return jdbcTemplate.update("INSERT INTO products (name, price) VALUES(:name, :price)",param);
    }

    public int update(ProductRecord record) {
//         オブジェクト　paramを作成
        MapSqlParameterSource param = new MapSqlParameterSource();
        // paramオブジェクトに""（名前）（値）を追加しています
        param.addValue("id", record.id());
        param.addValue("name", record.name());
        param.addValue("price", record.price());
        // SQLのクリエをDBで実行
        return jdbcTemplate.update("UPDATE products SET name = :name, price = :price WHERE id = :id", param);

    }

    public int delete(int id) {
        // オブジェクト　paramを作成
        MapSqlParameterSource param = new MapSqlParameterSource();
        // paramオブジェクトに""（名前）（値）を追加しています
        param.addValue("id", id);
        // SQLのクリエをDBで実行
        return jdbcTemplate.update("DELETE FROM products WHERE id = :id;", param);
    }
}
