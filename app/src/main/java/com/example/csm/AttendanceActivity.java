package com.example.csm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity {
    private ArrayList<AttendanceItems> iAttendanceList;
    private RecyclerView iRecyclerView;
    private AttendanceAdapter iAdapter;
    private RecyclerView.LayoutManager iLayoutManager;
    private Button btnAttInsert;
    private EditText edittxt_sub;
    private ImageView btnplus;
    private ImageView btnminus;

    private int upper;

    private double ipercent;
    private int numerator=0;
    private int denominator=1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        createAttendanceList();
        builRecyclerView();
        setButtons();

    }

    public double getIpercent(){
        ipercent=((numerator/denominator)*100);
        iAdapter.notifyDataSetChanged();
        return ipercent;

    }

    public void CountIN(View v){
        numerator = 1;
        numerator++;
        denominator++;
        iAdapter.notifyDataSetChanged();

    }

    public void CountDE(View v){
        numerator--;
        iAdapter.notifyDataSetChanged();

    }

    public void setButtons() {
        btnAttInsert = findViewById(R.id.btnatte_insert);
        edittxt_sub = findViewById(R.id.edittxt_sub);

        btnAttInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subj = edittxt_sub.getText().toString();
                String per = new Double(getIpercent()).toString();
                insertAttItem(subj,per);
            }
        });
    }



    public void insertAttItem(String subj,String per) {
        iAttendanceList.add(new AttendanceItems(R.drawable.ic_attendance,subj,per));
        iAdapter.notifyDataSetChanged();
    }

    public void removeAttItem(int Position){
        iAttendanceList.remove(Position);
        iAdapter.notifyItemRemoved(Position);
    }


    public void builRecyclerView() {
        iRecyclerView = findViewById(R.id.recyclerViewatt);
        iRecyclerView.setHasFixedSize(true);
        iLayoutManager = new LinearLayoutManager(this);
        iAdapter = new AttendanceAdapter(iAttendanceList);

        iRecyclerView.setLayoutManager(iLayoutManager);
        iRecyclerView.setAdapter(iAdapter);

        iAdapter.setOnItemClickListener(new AttendanceAdapter.OnItemClickListener() {
            @Override
            public void onDeleteAttClick(int position) {

                removeAttItem(position);
            }
        });


    }

    public void createAttendanceList() {
        iAttendanceList =new ArrayList<>();


    }

}
