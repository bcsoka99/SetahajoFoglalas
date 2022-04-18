package com.example.setahajofoglalas;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ResgisterActivity extends AppCompatActivity {
    EditText username;
    EditText passoword1;
    EditText password2;
    Button register;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        username = findViewById(R.id.RegisterUsername);
        passoword1 = findViewById(R.id.RegisterPassword1);
        password2 = findViewById(R.id.RegisterPassword2);
        register = findViewById(R.id.RegisterRegistration);
        register.setOnClickListener(event -> register());
        Bundle bundle = getIntent().getExtras();

        auth = FirebaseAuth.getInstance();
    }

    public void register() {
        String usernameTxt = username.getText().toString();
        String passwordTxt1 = passoword1.getText().toString();
        String passwordTxt2 = password2.getText().toString();
        Log.d(TAG, "asd1");
        if (passwordTxt2.equals(passwordTxt1)){
            Log.d(TAG, "asd2");
            auth.createUserWithEmailAndPassword(usernameTxt, passwordTxt1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Log.d(TAG, "Registration Succesful");
                        startFoglalas();
                    }else {
                        Log.d(TAG, "Registration Failed");
                    }
                }
            });
        }
    }

    private void startFoglalas(){
        Intent register = new Intent(this, MainActivity.class);
        startActivity(register);
    }

}