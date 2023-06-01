package com.example.lesson;

import com.example.lesson.record.ProductRecord;
import com.example.lesson.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LessonApplication {

	public static void main(String[] args) {
		// SpringApplication.runをすることでDIをコード場で使えるようにしている
		ConfigurableApplicationContext context =
				SpringApplication.run(LessonApplication.class, args);

		// インターフェースサービスのデータを取得してします
		ProductService productService = context.getBean(ProductService.class);

		// リスト情報をすべて表示
// 		// findAll()メソッドのデータをリストで取得しています
//		var list = productService.findAll();
//		// リストのデータをすべて出力しています
//		list.stream().forEach(System.out::println);

		// ID検索
//		var user = productService.findById(1); // IDが１のユーザーのみを取得
//		System.out.println(user);

		// インサート
	// 追加する情報をレコードクラスの値に入れ散る。それをnwwUserの渡している
//	var nwwUser = new ProductRecord(4, "定規", 100);
//		// レコードクラスの情報をもつnwwUserと一緒にインターフェースサービスに処理を渡している
//		productService.insert(nwwUser);
//		// 追加されたかどうか確認するためにID検索をしている
//		var user = productService.findById(4);
//		System.out.println(user);

		// アップデート
	// 変更したい値のデータ入力してnewUserに渡している
//	var newUser = new ProductRecord(4, "筆箱", 250);
//		// newUserのデータをもたしてインターフェースサービスに処理を渡している
//		productService.update(newUser);
//		// 値の変更/更新が出来ているかの確認のためID検索を行う
//		var user = productService.findById(4);
//		System.out.println(user);

		// デリート
		// インターフェースサービスにデリートするIDを渡している
		productService.delete(4);
		// デリート出来たかの確認
		var list = productService.findAll();
		list.stream().forEach(System.out::println);
	}

}
