package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//public class WordAdapter extends ArrayAdapter {
//
//    public WordAdapter(Context context, ArrayList<Word> pWords) {
//        super(context,0, pWords);
//    }
//
//
//
//
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        // Check if the existing view is being reused, otherwise inflate the view
//        View listItemView = convertView;
//
//        if(listItemView == null) {
//            listItemView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.list_item, parent, false);
//        }
//        Word local_word = getItem(position);
//        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
//        miwokTextView.setText(local_word.getMiwokTranslation());
//        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
//        defaultTextView.setText(local_word.getDefaultTranslation());
//
//        return listItemView;
//    }
//}

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

//    public WordAdapter(Context context, List<Word> objects) {}
    public WordAdapter(Context context, ArrayList<Word> pWords, int colorResourceId) {
        super(context,0, pWords);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
//    }

    public View getView(int position, View convertView, ViewGroup parent) {

// Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word local_word = getItem(position);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(local_word.getMiwokTranslation());
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(local_word.getDefaultTranslation());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(local_word.getmImageResourceId());

        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);

        return listItemView;
    }



}
