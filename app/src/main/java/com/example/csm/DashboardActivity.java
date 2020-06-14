package com.example.csm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.csm.R;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        ImageView imgAssin = (ImageView) findViewById(R.id.imgassign);
        imgAssin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AssignmentActivity.class );
                startActivity( intent);
            }
        });

        TextView txtAssin = (TextView) findViewById(R.id.txtassing);
        txtAssin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AssignmentActivity.class );
                startActivity( intent);
            }
        });

        ImageView imgAtten = (ImageView) findViewById(R.id.imgatten);
        imgAtten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AttendanceActivity.class );
                startActivity( intent);
            }
        });


        TextView txtAtten = (TextView) findViewById(R.id.txtatten);
        txtAtten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AttendanceActivity.class );
                startActivity( intent);
            }
        });

    }
}
