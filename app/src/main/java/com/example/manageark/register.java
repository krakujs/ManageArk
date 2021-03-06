package com.example.manageark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class register extends AppCompatActivity {
    TextView Email,Password,login;
    TextInputLayout EmailLayout,PasswordLayout;
    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //hooks
        Email = findViewById(R.id.signup_email_EditText);
        EmailLayout =findViewById(R.id.signup_email_TextInputLayout);

        Password = findViewById(R.id.signup_password_EditText);
        PasswordLayout =findViewById(R.id.signup_password_TextInputLayout);

        next = findViewById(R.id.user_next_bt);
        login = findViewById(R.id.txt_login);


        // login button on click
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwitchToLogin();
            }
        });

        // added text changed to remove set error of layout
        Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                EmailLayout.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                EmailLayout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                EmailLayout.setError(null);
            }
        });

        Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PasswordLayout.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PasswordLayout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                PasswordLayout.setError(null);
            }
        });

        // next button to switch to register details for first time
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                if(email.isEmpty()){
                    EmailLayout.requestFocus();
                    EmailLayout.setError("Please enter your Email");
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    EmailLayout.requestFocus();
                    EmailLayout.setError("Please enter correct email");
                    return;
                }
                if(password.isEmpty()){
                    PasswordLayout.requestFocus();
                    PasswordLayout.setError("Please enter your password");
                    return;
                }
                if(password.length()<8) {
                    PasswordLayout.requestFocus();
                    PasswordLayout.setError("Password must be more than 8 characters");
                    return;
                }
                //need to change
                //
                 Intent intent = new Intent(register.this, RegisterDetails.class);
                        intent.putExtra("Email",email);
                        intent.putExtra("Password",password);
                        startActivity( intent );
            }
        });

        }




    private void SwitchToLogin() {
        Intent intent = new Intent(register.this, LoginMain.class);
        startActivity( intent );
    }

}