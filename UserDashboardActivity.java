package com.example.organdonation.user;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.organdonation.R;
import com.example.organdonation.common.AwarenessActivity;

public class UserDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_user_dashboard);

        findViewById(R.id.btnDonate)
            .setOnClickListener(v -> startActivity(
                new Intent(this, DonateOrganActivity.class)));

        findViewById(R.id.btnRequest)
            .setOnClickListener(v -> startActivity(
                new Intent(this, RequestOrganActivity.class)));

        findViewById(R.id.btnAwareness)
            .setOnClickListener(v -> startActivity(
                new Intent(this, AwarenessActivity.class)));
    }
}
