package com.example.organdonation.admin;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.organdonation.R;
import com.google.firebase.firestore.FirebaseFirestore;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_admin);

        findViewById(R.id.verify).setOnClickListener(v ->
            FirebaseFirestore.getInstance()
                .collection("users")
                .document("HOSPITAL_UID")
                .update("verified", true)
        );
    }
}

