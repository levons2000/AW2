package com.example.levon.exampletwo;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterForPosts extends RecyclerView.Adapter<AdapterForPosts.ViewH>{
    private List<Model> listOfModels;
    Context context;


    public AdapterForPosts(List<Model> listOfModels, Context context) {
        this.listOfModels = listOfModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.items_style, parent, false);
        return new ViewH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewH holder, int position) {
        Model model = listOfModels.get(position);
        Picasso.get().load(model.getImgUrl()).into(holder.imageView);
    }

    public void commentSetter(CommentModel commentModel){

    }

    @Override
    public int getItemCount() {
        return listOfModels.size();
    }


    class ViewH extends RecyclerView.ViewHolder{
        ImageButton likeButton;
        ImageButton commentButton;
        Button shareButton;
        ImageView imageView;
        TextView likeCounterText;
        TextView commentCounterText;
        ListView listView;
        LinearLayout linearLayout;
        Button addComment;
        EditText commentName;
        EditText commentText;



        public ViewH(View v) {
            super(v);
            imageView = v.findViewById(R.id.imageforitem);
            likeButton =  v.findViewById(R.id.likebutton);
            commentButton = v.findViewById(R.id.commentbutton);
            shareButton = v.findViewById(R.id.sharebutton);
            likeCounterText = v.findViewById(R.id.likecountertext);
            commentCounterText =  v.findViewById(R.id.commentcountertext);
            listView =  v.findViewById(R.id.commentlistview);
            linearLayout = v.findViewById(R.id.commentlayout);
            addComment = v.findViewById(R.id.addnewcomment);
            commentName = v.findViewById(R.id.commentatorname);
            commentText = v.findViewById(R.id.newcommenttext);
            //listView.setAdapter(new CommentAdapter(context, R.layout.comment_style, listOfModels.get(getAdapterPosition()).arrayList));

            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listOfModels.remove(getAdapterPosition());
                    notifyDataSetChanged();
                    return false;
                }
            });

            likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!listOfModels.get(getAdapterPosition()).isLiked){
                    listOfModels.get(getAdapterPosition()).plusLike();
                    likeCounterText.setText(String.valueOf(listOfModels.get(getAdapterPosition()).likeCounter));
                    likeButton.setImageResource(R.drawable.liked);
                    listOfModels.get(getAdapterPosition()).isLiked = true;
                    }else {
                        listOfModels.get(getAdapterPosition()).minusLike();
                        likeCounterText.setText(String.valueOf(listOfModels.get(getAdapterPosition()).likeCounter));
                        likeButton.setImageResource(R.drawable.not_liked);
                        listOfModels.get(getAdapterPosition()).isLiked = false;
                    }
                }
            });


            commentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listView.setAdapter(new CommentAdapter(context, R.layout.comment_style, listOfModels.get(getAdapterPosition()).arrayList));
                    if (!listOfModels.get(getAdapterPosition()).isCommentActive){
                        listView.setVisibility(ListView.VISIBLE);
                        listOfModels.get(getAdapterPosition()).isCommentActive = true;
                    }else {
                        listView.setVisibility(ListView.GONE);
                        listOfModels.get(getAdapterPosition()).isCommentActive = false;
                    }
                }
            });

            shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    commentName.setText("");
                    commentText.setText("");
                    linearLayout.setVisibility(LinearLayout.VISIBLE);
                }
            });

            addComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listOfModels.get(getAdapterPosition()).plusComment();
                    listOfModels.get(getAdapterPosition()).arrayList.add(new CommentModel(commentName.getText().toString(), commentText.getText().toString()));
                    commentCounterText.setText(String.valueOf(listOfModels.get(getAdapterPosition()).commentCounter));
                    linearLayout.setVisibility(LinearLayout.GONE);

                }
            });



        }

    }
}
