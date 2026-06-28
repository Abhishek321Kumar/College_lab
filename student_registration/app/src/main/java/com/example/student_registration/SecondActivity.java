package com.example.student_registration;

import static com.example.student_registration.MainActivity.branch;
import static com.example.student_registration.MainActivity.name;
import static com.example.student_registration.MainActivity.section;
import static com.example.student_registration.MainActivity.usn;

import android.content.Intent;
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
        t1 = (TextView) findViewById(R.id.textView7);
        t2 = (TextView) findViewById(R.id.textView8);
        t3 = (TextView) findViewById(R.id.textView9);
        t4 = (TextView) findViewById(R.id.textView10);
        Intent i=getIntent();
        s1=i.getStringExtra(usn);
        s2=i.getStringExtra(name);
        s3=i.getStringExtra(branch);
        s4=i.getStringExtra(section);
        t1.setText("USN : " + s1);
        t2.setText("Name : " + s2);
        t3.setText("Branch : " + s3);
        t4.setText("Section : " + s4);


    }
}
