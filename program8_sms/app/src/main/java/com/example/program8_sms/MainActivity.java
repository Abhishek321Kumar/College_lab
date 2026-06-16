package com.example.program8_sms;

import android.Manifest;
import androidx.appcompat.app.AppCompatActivity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 123;

    EditText recipientEditText;
    EditText messageEditText;
    Button sendButton;

    PendingIntent sentPendingIntent;
    PendingIntent deliveredPendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipientEditText = findViewById(R.id.Pnumber);
        messageEditText = findViewById(R.id.mes);
        sendButton = findViewById(R.id.send);

        sentPendingIntent = PendingIntent.getBroadcast(
                this,
                0,
                new Intent("SMS_SENT"),
                PendingIntent.FLAG_IMMUTABLE
        );

        deliveredPendingIntent = PendingIntent.getBroadcast(
                this,
                0,
                new Intent("SMS_DELIVERED"),
                PendingIntent.FLAG_IMMUTABLE
        );

        sendButton.setOnClickListener(view -> {

            String recipient = recipientEditText.getText().toString();
            String message = messageEditText.getText().toString();

            if (recipient.isEmpty() || message.isEmpty()) {
                Toast.makeText(
                        MainActivity.this,
                        "Recipient and Message cannot be empty",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            if (checkSelfPermission(Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS
                );

            } else {
                sendSMS(recipient, message);
            }
        });
    }

    private void sendSMS(String recipient, String message) {

        try {

            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(
                    recipient,
                    null,
                    message,
                    sentPendingIntent,
                    deliveredPendingIntent
            );

            Toast.makeText(
                    this,
                    "Message sent successfully",
                    Toast.LENGTH_SHORT
            ).show();

        } catch (Exception e) {

            Toast.makeText(
                    this,
                    "Failed to send a SMS",
                    Toast.LENGTH_SHORT
            ).show();

            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            String[] permissions,
            int[] grantResults) {

        super.onRequestPermissionsResult(
                requestCode,
                permissions,
                grantResults
        );

        if (requestCode == MY_PERMISSIONS_REQUEST_SEND_SMS) {

            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                String recipient =
                        recipientEditText.getText().toString();

                String message =
                        messageEditText.getText().toString();

                sendSMS(recipient, message);

            } else {

                Toast.makeText(
                        this,
                        "SMS permission denied.Cannot send SMS.",
                        Toast.LENGTH_SHORT
                ).show();
            }
        }
    }
}