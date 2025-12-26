package com.example.organdonation.hospital;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.organdonation.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class HospitalDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_hospital);

        findViewById(R.id.add).setOnClickListener(v -> {
            Map<String, Object> data = new HashMap<>();
            data.put("hospitalId", FirebaseAuth.getInstance().getUid());
            data.put("organ", "Heart");
            data.put("available", true);

            FirebaseFirestore.getInstance()
                .collection("hospital_organs")
                .add(data);
        });
    }
}
