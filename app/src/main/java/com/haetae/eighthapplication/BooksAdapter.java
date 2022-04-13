package com.haetae.eighthapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BooksAdapter extends ArrayAdapter<Book> {


    public BooksAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.book_item, parent, false);
        Book book = getItem(position);
        TextView bookName = view.findViewById(R.id.bookname);
        TextView price = view.findViewById(R.id.price);
        bookName.setText(book.getName());
        price.setText(book.getPrice()+"元");
        return view;
    }
}
