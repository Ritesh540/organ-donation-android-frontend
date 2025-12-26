package com.example.organdonation.user;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.organdonation.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class DonateOrganActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_donate);

        findViewById(R.id.submit).setOnClickListener(v -> {
            Map<String, Object> data = new HashMap<>();
            data.put("userId", FirebaseAuth.getInstance().getUid());
            data.put("organ", "Kidney");
            data.put("status", "Active");

            FirebaseFirestore.getInstance()
                .collection("donor_requests")
                .add(data);
        });
    }
}
