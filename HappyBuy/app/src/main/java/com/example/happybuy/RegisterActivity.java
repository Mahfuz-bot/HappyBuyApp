package com.example.happybuy;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText regEmailEditText, regPassEditText, regPhoneEditText;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        regEmailEditText = findViewById(R.id.emailEditTextID);
        regPassEditText = findViewById(R.id.passEditTextID);
        regPhoneEditText = findViewById(R.id.phoneEditTextID);
        Button regButton = findViewById(R.id.regButtonID);

        regButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.regButtonID) {
            userRegister();
        }
}

    private void userRegister() {

        String email = regEmailEditText.getText().toString().trim();
        String pass = regPassEditText.getText().toString().trim();
        String phone = regPhoneEditText.getText().toString().trim();

        if(email.isEmpty())
        {
            regEmailEditText.setError("Enter a email address");
            regEmailEditText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            regEmailEditText.setError("Enter valid email address");
            regEmailEditText.requestFocus();
            return;
        }

        if(pass.length() < 6)
        {
            regPassEditText.setError("Minimum length of a password should be 6");
            regPassEditText.requestFocus();
            return;
        }

        if(phone.isEmpty())
        {
            regPhoneEditText.setError("Enter Phone No.");
            regPhoneEditText.requestFocus();
        }

        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(getApplicationContext(), "User is already registered", Toast.LENGTH_SHORT).show();

                    }else
                    {
                        Toast.makeText(getApplicationContext(), "ERROR: "+ Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}
