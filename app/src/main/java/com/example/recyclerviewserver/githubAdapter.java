package com.example.recyclerviewserver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class githubAdapter extends RecyclerView.Adapter<githubAdapter.GithubViewHolder>{

    private  Context context;
    private User[] data;
    public githubAdapter(Context context,User[] data){

        this.context = context;
        this.data = data;

    }


    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user_layout,parent,false);
        return new GithubViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder holder, int position) {

        final User user = data[position];
        holder.txtuser.setText(user.getLogin());
        Glide.with(holder.imguser.getContext()).load(user.getAvatarUrl()).into(holder.imguser);
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(context,user.getLogin()+ "was clicked", Toast.LENGTH_LONG).show();
             }
         });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder{

        ImageView imguser;
        TextView txtuser;

        public GithubViewHolder(@NonNull View itemView) {
            super(itemView);
            imguser = (ImageView) itemView.findViewById(R.id.imguser);
            txtuser = (TextView)  itemView.findViewById(R.id.txtuser);
        }
    }

}
