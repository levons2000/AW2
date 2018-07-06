package com.example.levon.exampletwo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by HP on 7/5/2018.
 */

public class CommentAdapter extends ArrayAdapter {
    private Context context;
    private List<CommentModel> list;
    private int resource;

    public CommentAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (convertView == null) {
            v = LayoutInflater.from(context).inflate(R.layout.comment_style, parent, false);
        }

        CommentModel commentModel = list.get(position);
        TextView textViewName =  v.findViewById(R.id.commentname);
        TextView textViewComment =  v.findViewById(R.id.comenttext);
        textViewName.setText(commentModel.getName() + ":");
        textViewComment.setText(commentModel.getText());
        return v;
    }
}
