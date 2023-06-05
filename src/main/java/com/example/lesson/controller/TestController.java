package com.example.lesson.controller;

import com.example.lesson.record.ProductRecord;
import com.example.lesson.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;


@Controller
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/product-list")
    public String productList(Model model) {
        // ロジックをServiceに任せる
        var products = testService.findAll();
        model.addAttribute("products", products);
        return "user-list";
    }
    @GetMapping("/product/{id}")

    public String productList(@PathVariable("id") int id, Model model) {
        var product = testService.findById(id);
        model.addAttribute("products", product);
        return "products-idlist";
    }

}
