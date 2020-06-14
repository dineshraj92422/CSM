package com.example.csm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AssingmentAdapter extends RecyclerView.Adapter<AssingmentAdapter.AssingmentViemHolder> {

    private ArrayList<AssingmentsItem> mAssingmentsList;
    private onItemClickListner mListner;

    public void setOnItemClickListner(onItemClickListner listner){
        mListner = listner;
    }

    public interface onItemClickListner{
        void onDeleteClick(int position);
    }

    public static class AssingmentViemHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public ImageView mDelete;


        public AssingmentViemHolder(@NonNull View itemView, final onItemClickListner listner) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imgassiv);
            mTextView1 = itemView.findViewById(R.id.txtv1);
            mTextView2 = itemView.findViewById(R.id.txtv2);
            mDelete = itemView.findViewById(R.id.img_delete);


           mDelete.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (listner != null) {
                       int position = getAdapterPosition();
                       if (position != RecyclerView.NO_POSITION) {
                           listner.onDeleteClick(position);
                       }
                   }
               }
           });

        }
    }

    public AssingmentAdapter(ArrayList<AssingmentsItem> assingmentsList) {

        mAssingmentsList = assingmentsList;

    }

    @NonNull
    @Override
    public AssingmentViemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignments_item, parent, false);
        AssingmentViemHolder avh = new AssingmentViemHolder(v,mListner);
        return avh;
    }

    @Override
    public void onBindViewHolder(@NonNull AssingmentViemHolder holder, int position) {

        AssingmentsItem currentItem = mAssingmentsList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());

    }

    @Override
    public int getItemCount() {
        return mAssingmentsList.size();
    }
}
