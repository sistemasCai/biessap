package com.biessap.biessap.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PreguntaAdapter extends BaseAdapter {

    private final Context mContext;
    private final String[] books;

    public PreguntaAdapter(Context context, String numero[]) {
        this.mContext = context;
        this.books = numero;
    }

    @Override
    public int getCount() {
        return books.length;
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return books[position];
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView dummyTextView = new TextView(mContext);
        dummyTextView.setText(books[position]);
        return dummyTextView;
    }
}

