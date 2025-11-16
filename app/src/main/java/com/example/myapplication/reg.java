package com.example.myapplication;



import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class reg extends AppCompatActivity {

    private EditText etEmail, etPassword, etConfirmPassword;
    private Button btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        etEmail = findViewById(R.id.r1);
        etPassword = findViewById(R.id.r2);
        etConfirmPassword = findViewById(R.id.r3);
        btnRegister = findViewById(R.id.rb3);
        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(reg.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(reg.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(reg.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                        // Add further actions after successful registration, e.g., navigate to home activity
                                    } else {
                                        Toast.makeText(reg.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        Log.e("RegisterActivity", "Registration failed: " + task.getException().getMessage());
                                    }
                                }
                            });
                }


                Intent intent = new Intent(reg.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }
}

