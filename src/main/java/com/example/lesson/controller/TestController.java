package com.example.lesson.controller;

import com.example.lesson.form.ProductForm;
import com.example.lesson.record.ProductRecord;
import com.example.lesson.service.TestService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@Controller
public class TestController {
    // サービスクラスのインサートを取得している
    @Autowired
    TestService testService;

    // リクエストをゲットしている
    @GetMapping("/product-list")
    // メソッドを作っている
    public String productList(Model model) {
        // ロジックをServiceに任せる
        var products = testService.findAll();
        // HTMLファイルでテーブルの値を使えるようにしている
        model.addAttribute("products", products);
        //
        return "user-list";
    }

    @GetMapping("/product/{id}")

    public String productList(@PathVariable("id") Integer id, Model model) {
        var product = testService.findById(id);
        model.addAttribute("product", product);
        return "products-idlist";
    }

    @GetMapping("/product-add")
    public String productadd(@Validated @ModelAttribute("productForm") ProductForm productForm, BindingResult bindingResult) {
        // バリデーション
        if(bindingResult.hasErrors()) {
            return "productadd";
        }
        return "productadd";
    }

    @PostMapping("/product-add")
    public String add(@Validated @ModelAttribute("productForm") ProductForm productForm, BindingResult bindingResult) {
        // バリデーション
        if(bindingResult.hasErrors()) {
            return "productadd";
        }

        var name = productForm.getName();
        var price = productForm.getPrice();
//        productForm.setPrice(100);

        testService.insert(name,price);
        return "redirect:/product-list";
    }

    @GetMapping("/product/update/{id}")
    public String update( @ModelAttribute("productForm") ProductForm productForm
                         ,@PathVariable("id") Integer id, Model model) {


        var product = testService.findById(id);
        productForm.setId(product.id());
        productForm.setName(product.name());
        productForm.setPrice(product.price());



        return "products-update";
    }

    @PostMapping("/product/update/{id}")
    public String update2(@Validated @ModelAttribute("productForm") ProductForm productForm, BindingResult bindingResult
                          ,@PathVariable("id") Integer id, Model model) {
        // バリデーション
        if(bindingResult.hasErrors()) {
            return "products-update";
        }

        var name = productForm.getName();
        var price = productForm.getPrice();

        testService.update(id, name,price);

        return "redirect:/product-list";
    }

    @PostMapping("/product/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model, @ModelAttribute("productForm") ProductForm productForm) {
        testService.delete(id);

        return "redirect:/product-list";
    }
}
