package com.salesianostriana.pmdm.bbva_sms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BBVA_SMS extends AppCompatActivity {
    EditText editTextSmsCode;
    Button btnConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbva__sms);

        editTextSmsCode = (EditText) findViewById(R.id.editTextSmsCode);
        btnConfirm = (Button) findViewById(R.id.btnConfirmar);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PENDIENTE DE COMPLETAR
            }
        });
    }
}
