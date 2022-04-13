package com.haetae.eighthapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Book> books = prepareData();
        ListView lv = findViewById(R.id.bookList);
        Button addBook = findViewById(R.id.addBook);
        BooksAdapter adapter = new BooksAdapter(this,R.layout.book_item,books);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            Book book = books.get(i);
            Intent intent = new Intent(this, BookDetailActivity.class);
            intent.putExtra("book",book.toString());
            startActivity(intent);
        });
        addBook.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddBookActivity.class);
            startActivity(intent);
        });

    }
    ArrayList<Book> prepareData() {
//        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("/data/books.db", null);
        LibraryOpenHelper dbHelper = new LibraryOpenHelper(this,"books.db",null,1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selectAll = "select Book.id,author,name,price,pages,category_name,category_code " +
                            "from Book,Category " +
                            "where category_id=Category.id";
        Cursor cursor = db.rawQuery(selectAll, null);
        ArrayList<Book> books = new ArrayList<>();
        while(cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String author = cursor.getString(cursor.getColumnIndexOrThrow("author"));
            double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
            int pages = cursor.getInt(cursor.getColumnIndexOrThrow("pages"));
            String category_name = cursor.getString(cursor.getColumnIndexOrThrow("category_name"));
            int category_code = cursor.getInt(cursor.getColumnIndexOrThrow("category_code"));
            books.add(new Book(id,author,name,price,pages,category_name,category_code));
        }
        return books;
    }
}