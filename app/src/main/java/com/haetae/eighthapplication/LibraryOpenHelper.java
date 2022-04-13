package com.haetae.eighthapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LibraryOpenHelper extends SQLiteOpenHelper {
    public LibraryOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        System.out.println("111111111111");
        final String bookCreate = "create table Book (" +
                "id integer primary key autoincrement," +
                "author text," +
                "price real," +
                "pages integer," +
                "name text," +
                "category_id integer" +
                ")";
        final String categoryCreate ="create table Category(" +
                "id integer primary key autoincrement," +
                "category_name text," +
                "category_code integer" +
                ")";
        sqLiteDatabase.execSQL(bookCreate);
        sqLiteDatabase.execSQL(categoryCreate);
        ContentValues category = new ContentValues();
        category.put("id",1);
        category.put("category_name","经济系");
        category.put("category_code",1);
        sqLiteDatabase.insert("Category",null,category);
        category.put("id",2);
        category.put("category_name","数学系");
        category.put("category_code",2);
        sqLiteDatabase.insert("Category",null,category);
        ContentValues books = new ContentValues();
        books.put("id","1");
        books.put("author","黄鸿瑜");
        books.put("price",20.00);
        books.put("name","java后端开发");
        books.put("pages",100);
        books.put("category_id",1);
        sqLiteDatabase.insert("Book",null,books);
        books.put("id",2);
        books.put("author","陈烁松");
        books.put("price",20.00);
        books.put("pages",100);
        books.put("name","算法与数据结构");
        books.put("category_id",1);
        sqLiteDatabase.insert("Book",null,books);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
