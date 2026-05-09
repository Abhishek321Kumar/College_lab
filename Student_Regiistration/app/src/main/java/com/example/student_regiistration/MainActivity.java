package com.example.student_regiistration;

import android.os.Bundle;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText input1, input2, input3, input4, input5;
    Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        input1 = findViewById(R.id.input_1);
        input2 = findViewById(R.id.input_2);
        input3 = findViewById(R.id.input_3);
        input4 = findViewById(R.id.input_4);
        input5 = findViewById(R.id.input_5);

        registerButton = findViewById(R.id.button);

        // Button Click Event
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Getting user inputs
                String usn = input1.getText().toString();
                String name = input2.getText().toString();
                String branch = input3.getText().toString();
                String semester = input4.getText().toString();
                String section = input5.getText().toString();

                // Intent to move to SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // Sending data
                intent.putExtra("USN", usn);
                intent.putExtra("NAME", name);
                intent.putExtra("BRANCH", branch);
                intent.putExtra("SEMESTER", semester);
                intent.putExtra("SECTION", section);

                startActivity(intent);
            }




        });
    }
}