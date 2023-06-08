package com.example.lesson.form;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ProductForm {
    private Integer id;

    @NotEmpty(message = "必須項目")
    @Length(min = 1, max = 50)
    private String name;
    @NotNull(message = "必須項目")
    @Digits(integer = 10, fraction = 0, message = "10桁以内、０桁以上の数値のみ入力可能")
    @Min(value = 0, message = "最小値0以上の値が有効です")
    private int price;
}
