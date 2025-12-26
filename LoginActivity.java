package com.example.organdonation.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.organdonation.R;
import com.example.organdonation.admin.AdminDashboardActivity;
import com.example.organdonation.hospital.HospitalDashboardActivity;
import com.example.organdonation.user.UserDashboardActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        findViewById(R.id.loginBtn).setOnClickListener(v -> {
            String email = ((EditText)findViewById(R.id.email)).getText().toString();
            String password = ((EditText)findViewById(R.id.password)).getText().toString();

            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(res -> {
                    db.collection("users")
                      .document(auth.getUid())
                      .get()
                      .addOnSuccessListener(doc -> {
                          String role = doc.getString("role");
                          if ("admin".equals(role))
                              startActivity(new Intent(this, AdminDashboardActivity.class));
                          else if ("hospital".equals(role))
                              startActivity(new Intent(this, HospitalDashboardActivity.class));
                          else
                              startActivity(new Intent(this, UserDashboardActivity.class));
                      });
                });
        });
    }
}
