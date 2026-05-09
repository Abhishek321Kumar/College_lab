package com.example.student_regiistration;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4, tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Connecting TextViews
        tv1 = findViewById(R.id.textview_02);
        tv2 = findViewById(R.id.textview_04);
        tv3 = findViewById(R.id.textview_06);
        tv4 = findViewById(R.id.textview_08);
        tv5 = findViewById(R.id.textview_10);

        // Receiving data from MainActivity
        String usn = getIntent().getStringExtra("USN");
        String name = getIntent().getStringExtra("NAME");
        String branch = getIntent().getStringExtra("BRANCH");
        String semester = getIntent().getStringExtra("SEMESTER");
        String section = getIntent().getStringExtra("SECTION");

        // Setting data to TextViews
        tv1.setText(usn);
        tv2.setText(name);
        tv3.setText(branch);
        tv4.setText(semester);
        tv5.setText(section);
    }
}