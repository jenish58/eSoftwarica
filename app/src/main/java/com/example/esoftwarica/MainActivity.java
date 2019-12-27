package com.example.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etuserName, etpassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hide Title Bar
        getSupportActionBar().hide();

        etuserName = findViewById(R.id.userName);
        etpassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String userName = etuserName.getText().toString();
        String password = etpassword.getText().toString();

        //Validation
        if(etuserName.getText().toString().matches("")){
            etuserName.setError("Enter Your Username");
            return;
        }
        if(etpassword.getText().toString().matches("")){
            etpassword.setError("Enter Your password");
            return;
        }

        if(userName.equals("softwarica") && password.equals("coventry"))
        {
            Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

            etpassword.getText().clear();
            etuserName.getText().clear();
        }
        else
        {
            etuserName.setError("Please enter valid username");
            etpassword.setError("Please enter valid password");
            Toast.makeText(getApplicationContext(), "SORRY INVALID USER ID OR PASSWORD",Toast.LENGTH_LONG).show();
            etuserName.requestFocus();
        }

    }
}
