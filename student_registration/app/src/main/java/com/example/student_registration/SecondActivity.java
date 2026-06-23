package com.example.student_registration;

import static com.example.student_registration.MainActivity.branch;
import static com.example.student_registration.MainActivity.name;
import static com.example.student_registration.MainActivity.section;
import static com.example.student_registration.MainActivity.usn;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    String s1,s2,s3,s4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView);
        t3 = (TextView) findViewById(R.id.textView);
        t4 = (TextView) findViewById(R.id.textView);


    }
}
