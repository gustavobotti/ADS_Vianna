package com.example.layoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.layoutapp.model.Pessoa;

public class MainActivity2 extends AppCompatActivity {

    private EditText nome;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        binding();

        String vNome = getIntent().getExtras().getString("nome");
        int idade = getIntent().getExtras().getInt("idade");
        Pessoa p = (Pessoa) getIntent().getExtras().getSerializable("pessoa");

        nome.setText( p.getNome() );

        btn.setOnClickListener(clickVoltar());
    }

    private View.OnClickListener clickVoltar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent itn = new Intent();
                itn.putExtra("valor", nome.getText().toString());

                setResult(10);
                finish();
            }
        };

    }

    private void binding() {

        nome = findViewById(R.id.edtNome2);
        btn = findViewById(R.id.btnVoltar);
    }
}