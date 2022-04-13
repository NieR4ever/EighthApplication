package com.haetae.eighthapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AddBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        EditText name = findViewById(R.id.editTextBookName);
        EditText author = findViewById(R.id.editTextAuthorName);
        EditText price = findViewById(R.id.editTextPrice);
        EditText pages = findViewById(R.id.editTextPages);
        Button saveAdd = findViewById(R.id.saveAdd);
        saveAdd.setOnClickListener(view -> {
            LibraryOpenHelper helper = new LibraryOpenHelper(this, "books.db", null, 1);
            SQLiteDatabase db = helper.getWritableDatabase();
            db.execSQL("insert into book(name,author,price,pages,category_id) values(?,?,?,?,?)",
                    new Object[]{name.getText().toString()
                            ,author.getText().toString()
                            ,Double.parseDouble(price.getText().toString())
                            , Integer.parseInt(pages.getText().toString()),2
            });
            startActivity(new Intent(this,MainActivity.class));
        });
    }
}