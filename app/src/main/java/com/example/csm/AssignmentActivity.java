package com.example.csm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class AssignmentActivity extends AppCompatActivity {
    ArrayList<AssingmentsItem> mAssignmentList;

    private RecyclerView mRecyclerView;
    private AssingmentAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button mInsert;
    private EditText msub;
    private EditText mdead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        createAssignmentList();
        buildRecyclerView();
        setButtons();


    }

    public void insertItem(String sub,String dead){
        mAssignmentList.add(new AssingmentsItem(R.drawable.ic_assignment,sub,dead));
        mAdapter.notifyDataSetChanged();
    }

    public void removeItem(int Position){
        mAssignmentList.remove(Position);
        mAdapter.notifyItemRemoved(Position);
    }

    public void createAssignmentList(){
        mAssignmentList = new ArrayList<>();



    }

    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AssingmentAdapter(mAssignmentList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListner(new AssingmentAdapter.onItemClickListner() {
            @Override
            public void onDeleteClick(int position) {
                 removeItem(position);
            }
        });
    }

    public void setButtons(){
        msub=findViewById(R.id.edittxt_insert);
        mdead=findViewById(R.id.edittxt_deadline);
        mInsert=findViewById(R.id.btn_insert);
        mInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sub = msub.getText().toString();
                String dead = mdead.getText().toString();
                insertItem(sub,dead);
            }
        });



    }
}
