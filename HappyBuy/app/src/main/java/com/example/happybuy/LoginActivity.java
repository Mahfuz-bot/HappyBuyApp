package com.example.happybuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText loginEmailEditText, loginPassEditText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        loginEmailEditText = findViewById(R.id.emailEditTextID);
        loginPassEditText = findViewById(R.id.passEditTextID);
        Button loginButton = findViewById(R.id.loginButtonID);
        TextView forgotText = findViewById(R.id.forgotTextID);
        TextView regText = findViewById(R.id.regTextID);

        loginButton.setOnClickListener(this);
        forgotText.setOnClickListener(this);
        regText.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.loginButtonID:
                userLogin();
                break;

            case R.id.regTextID:
                finish();
                Intent intent = new Intent (getApplicationContext(), RegisterActivity.class);
                startActivity(intent);

            case R.id.forgotTextID:
                Toast.makeText(getApplicationContext(), "set new pass", Toast.LENGTH_SHORT).show();
        }

    }

    private void userLogin() {

        String email = loginEmailEditText.getText().toString().trim();
        String pass = loginPassEditText.getText().toString().trim();

        if(email.isEmpty())
        {
            loginEmailEditText.setError("Enter a email address");
            loginEmailEditText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            loginEmailEditText.setError("Enter valid email address");
            loginEmailEditText.requestFocus();
            return;
        }

        if(pass.length() < 6)
        {
            loginPassEditText.setError("Minimum length of a password should be 6");
            loginPassEditText.requestFocus();
        }


        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    finish();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Login Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
