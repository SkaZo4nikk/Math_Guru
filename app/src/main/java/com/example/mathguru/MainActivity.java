package com.example.mathguru;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText eTextPassword;
    private EditText eTextEmailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    Intent intent = new Intent(MainActivity.this, MathTest.class);
                    startActivity(intent);
                } else {
                    // User is signed out
                }
            }
        };

        eTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        eTextPassword = (EditText) findViewById(R.id.editTextTextPassword);

        findViewById(R.id.buttonAuth).setOnClickListener(this);
        findViewById(R.id.buttonReg).setOnClickListener(this);

        Intent intent = new Intent(MainActivity.this, MathTest.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonAuth)
            signing(eTextEmailAddress.getText().toString(), eTextPassword.getText().toString());
        else if(view.getId() == R.id.buttonReg)
            registration(eTextEmailAddress.getText().toString(), eTextPassword.getText().toString());
    }

    public void signing(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Авторизация успешна", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, MathTest.class);
                    startActivity(intent);
                } else
                    Toast.makeText(MainActivity.this, "Авторизация провалена", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void registration(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Регистрация успешна", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, MathTest.class);
                    startActivity(intent);
                } else
                    Toast.makeText(MainActivity.this, "Регистрация провалена", Toast.LENGTH_LONG).show();
            }
        });
    }


}