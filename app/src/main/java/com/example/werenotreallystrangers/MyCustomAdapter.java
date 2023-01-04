package com.example.werenotreallystrangers;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private List<String> mData;
    private int mResource;
    private int mTextViewResourceId;
    private int mColor;
    private int mPosition;

    public MyCustomAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<String> objects, int color) {
        super(context, resource, textViewResourceId, objects);
        mContext = context;
        mResource = resource;
        mTextViewResourceId = textViewResourceId;
        mData = objects;
        mColor = color;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //sets the position to be shown next in the adapter
        position = mPosition;
        View view = super.getView(position, convertView, parent);
        //sets the color of the card based on the level chosen
        CardView cardView = view.findViewById(R.id.card_view);
        cardView.setCardBackgroundColor(mColor);

        return view;
    }

    //saves the position to be shown next in the adapter
    public void setPosition(int position){
        mPosition = position;
    }
}
