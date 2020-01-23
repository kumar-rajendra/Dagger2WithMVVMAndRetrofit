package com.example.mvvmrecyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvmrecyclerview.R;
import com.example.mvvmrecyclerview.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NicePlace> nicePlaces = new ArrayList<>();
    private Context mContext;

    public RecyclerAdapter(Context context, List<NicePlace> nicePlaces) {
        this.nicePlaces = nicePlaces;
        mContext = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //set the title
        ((ViewHolder)holder).mName.setText(nicePlaces.get(position).getTitle());

        //set the image

        // Set the image
        RequestOptions defaultOptions = new RequestOptions().error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(nicePlaces.get(position).getImageUrl())
                .into(((ViewHolder)holder).mImage);

        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(nicePlaces.get(position).getImageUrl())
                .into(((ViewHolder)holder).mSquareImage);

    }

    @Override
    public int getItemCount() {
        return nicePlaces.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mName;
        private CircleImageView mImage;
        private ImageView mSquareImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImage=itemView.findViewById(R.id.img_image);
            mName=itemView.findViewById(R.id.txt_name);
            mSquareImage=itemView.findViewById(R.id.image_square);
        }
    }
}
