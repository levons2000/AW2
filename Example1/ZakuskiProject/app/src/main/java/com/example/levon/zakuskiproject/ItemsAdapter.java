package com.example.levon.zakuskiproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class ItemsAdapter extends ArrayAdapter<Items> {
    private Context context;
    private List<Items> list;
    private int resource;


    public ItemsAdapter(@NonNull Context context, int resource, @NonNull List<Items> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        list = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(context).inflate(resource, parent, false);
        }
        final Items items = list.get(position);
        TextView textViewName = view.findViewById(R.id.name);
        textViewName.setText(items.getName());
        TextView textViewSubName = view.findViewById(R.id.subname);
        textViewSubName.setText(items.getCountry());
        ImageView imageView = view.findViewById(R.id.list_item_image);
        Picasso.get().load(items.getImgUrl()).into(imageView);
        calorieSetter(items, view);
        return view;
    }

    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    private void calorieSetter(Items items, View view){
        TextView textView = view.findViewById(R.id.calorie);
        switch (items.getCalorie().getI()){
            case 1:
                textView.setText("Low carb");
                textView.setTextColor(R.color.lowcrabColor);
                break;
            case 2:
                textView.setText("Medium carb");
                textView.setTextColor(R.color.mediumcarbColor);
                break;
            case 3:
                textView.setText("Balanced");
                textView.setTextColor(R.color.balancedColor);
                break;
            case 4:
                textView.setText("Low fat");
                textView.setTextColor(R.color.lowfatColor);
                break;
            case 5:
                textView.setText("Medium fat");
                textView.setTextColor(R.color.mediumfatColor);
                break;
        }
    }
}
