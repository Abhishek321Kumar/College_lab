package com.example.program7_studentdb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText rno,name,marks;
    Button insert,delete,update,viewbtn,viewall;
    SQLiteDatabase db;

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

        rno = findViewById(R.id.rollno);
        name = findViewById(R.id.name);
        marks = findViewById(R.id.marks);
        insert=findViewById(R.id.insert);
        delete = findViewById(R.id.delete);
        update= findViewById(R.id.update);
        viewbtn = findViewById(R.id.view);
        viewall = findViewById(R.id.viewAll);

        db = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student (rollno VARCHAR, name VARCHAR, marks VARCHAR);");

        insert.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        viewbtn.setOnClickListener(this);
        viewall.setOnClickListener(this);
    }

    public void onClick(View view) {

        if (view == insert) {

            if (rno.getText().toString().trim().length() == 0 ||
                    name.getText().toString().trim().length() == 0 ||
                    marks.getText().toString().trim().length() == 0) {

                showMessage("Error", "Please enter all values");
                return;
            }

            db.execSQL("INSERT INTO student VALUES('" +
                    rno.getText().toString() + "','" +
                    name.getText().toString() + "','" +
                    marks.getText().toString() + "')");

            showMessage("Success", "Record Added");
            clearText();
        }

        if (view == delete) {

            if (rno.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please Enter Rollno");
                return;
            }

            Cursor c = db.rawQuery(
                    "SELECT * FROM student WHERE rollno='" +
                            rno.getText().toString() + "'",
                    null);

            if (c.moveToFirst()) {

                db.execSQL(
                        "DELETE FROM student WHERE rollno='" +
                                rno.getText().toString() + "'");

                showMessage("Success", "Record Deleted");
            } else {
                showMessage("Error", "Invalid Rollno");
            }

            clearText();
        }

        if (view == update) {

            if (rno.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please Enter Rollno");
                return;
            }

            Cursor c = db.rawQuery(
                    "SELECT * FROM student WHERE rollno='" +
                            rno.getText().toString() + "'",
                    null);

            if (c.moveToFirst()) {

                db.execSQL(
                        "UPDATE student SET " +
                                "name='" + name.getText().toString() +
                                "', marks='" + marks.getText().toString() +
                                "' WHERE rollno='" +
                                rno.getText().toString() + "'");

                showMessage("Success", "Record Modified");
            } else {
                showMessage("Error", "Invalid Rollno");
            }

            clearText();
        }

        if (view == viewbtn) {

            if (rno.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please Enter Rollno");
                return;
            }

            Cursor c = db.rawQuery(
                    "SELECT * FROM student WHERE rollno='" +
                            rno.getText().toString() + "'",
                    null);

            if (c.moveToFirst()) {

                name.setText(c.getString(1));
                marks.setText(c.getString(2));

            } else {
                showMessage("Error", "Invalid Rollno");
                clearText();
            }
        }

        if (view == viewall) {

            Cursor c = db.rawQuery(
                    "SELECT * FROM student",
                    null);

            if (c.getCount() == 0) {
                showMessage("Error", "No Record Found");
                return;
            }

            StringBuffer buffer = new StringBuffer();

            while (c.moveToNext()) {

                buffer.append("Rollno : " + c.getString(0) + "\n");
                buffer.append("Name : " + c.getString(1) + "\n");
                buffer.append("Marks : " + c.getString(2) + "\n\n");
            }

            showMessage("Student Details", buffer.toString());
        }
    }

    public void showMessage(String title, String message) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText() {

        rno.setText("");
        name.setText("");
        marks.setText("");

        rno.requestFocus();
    }
}