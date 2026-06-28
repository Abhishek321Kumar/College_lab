package com.example.student_registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1;
    String s1,s2,s3,s4;
    public static final String usn = "com.example.student_registration.usn";
    public static final String name = "com.example.student_registration.name";
    public static final String section = "com.example.student_registration.section";
    public static final String branch = "com.example.student_registration.branch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        e1 = (EditText)findViewById(R.id.InputText1);
        e2 = (EditText) findViewById(R.id.InputText2);
        e3 = (EditText) findViewById(R.id.InputText3);
        e4 = (EditText) findViewById(R.id.InputText4);
        b1=(Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    s1 = e1.getText().toString();
                    s2 = e2.getText().toString();
                    s3 = e3.getText().toString();
                    s4=e4.getText().toString();
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra(usn, s1);
                i.putExtra(name, s2);
                i.putExtra(branch, s3);
                i.putExtra(section, s4);

                startActivity(i);
                }
        });

    }
}