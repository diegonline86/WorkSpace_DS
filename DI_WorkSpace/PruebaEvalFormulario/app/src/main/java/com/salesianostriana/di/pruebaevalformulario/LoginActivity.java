package com.salesianostriana.di.pruebaevalformulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_login;
    private EditText editTextEmail,editTextPassword;
    private CheckBox checkBoxTermsConds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = (Button)findViewById(R.id.btnLogin);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        checkBoxTermsConds = (CheckBox)findViewById(R.id.checkBoxTermConds);

        btn_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String email = editTextEmail.getText().toString();
        String pass = editTextPassword.getText().toString();

        if(email.equals("admin@admin.com") && pass.equals("1234") && checkBoxTermsConds.isChecked())
            Toast.makeText(this,"Login correcto",Toast.LENGTH_SHORT).show();
        else if(!checkBoxTermsConds.isChecked())
            Toast.makeText(this,"debe aceptar los términos y condiciones", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Login incorrecto", Toast.LENGTH_SHORT).show();
    }
}
