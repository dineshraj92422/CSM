package com.example.csm;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder> {
    private ArrayList<AttendanceItems> iAttendanceList;
    private OnItemClickListener iListener;

    public interface OnItemClickListener{
        void onDeleteAttClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        iListener = listener;
    }

    public static class AttendanceViewHolder extends RecyclerView.ViewHolder{

        public ImageView iImageView;
        public TextView iTextView1;
        public TextView iTextView2;
        public ImageView iDelete;
        public AttendanceViewHolder(View itemView, final OnItemClickListener listener){
            super(itemView);
        iImageView = itemView.findViewById(R.id.imgatted);
        iTextView1 = itemView.findViewById(R.id.txtav1);
        iTextView2 = itemView.findViewById(R.id.txtav2);
        iDelete = itemView.findViewById(R.id.imgatted_delete);

        iDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION)
                        listener.onDeleteAttClick(position);
                }

            }
        });
        }

    }

    public AttendanceAdapter(ArrayList<AttendanceItems> attendanceList){
        iAttendanceList = attendanceList;

    }

    @NonNull
    @Override
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_items,parent,false);
        AttendanceViewHolder atvh = new AttendanceViewHolder(v,iListener);
        return atvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder holder, int position) {
        AttendanceItems currentIteminatt = iAttendanceList.get(position);

        holder.iImageView.setImageResource(currentIteminatt.getImageResourceatt());
        holder.iTextView1.setText(currentIteminatt.getText1att());
        holder.iTextView2.setText(currentIteminatt.getText2att());

    }

    @Override
    public int getItemCount() {
        return iAttendanceList.size();
    }
}
