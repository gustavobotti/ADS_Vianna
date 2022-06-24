package com.example.layoutapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.layoutapp.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    private EditText nome;

    public static final int viewTela2 = 1;
    public static final int viewTela3 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        btn1.setOnClickListener(cliqueBotao1());
        btn2.setOnClickListener(cliqueBotao2());
        btn3.setOnClickListener(cliqueBotao3());
        btn4.setOnClickListener(cliqueBotao4());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == viewTela2){

            Toast.makeText(getApplicationContext(), "Voltei da tela 1"+resultCode, Toast.LENGTH_LONG).show();
            if(resultCode == 10){
                nome.setText("abc");
            }
        } else {
            Toast.makeText(getApplicationContext(), "Voltei", Toast.LENGTH_LONG).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private View.OnClickListener cliqueBotao4() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
    }

    private View.OnClickListener cliqueBotao3() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
    }

    private View.OnClickListener cliqueBotao2() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(),MainActivity3.class);

                startActivityForResult(itn,viewTela3);

            }
        };
    }

    private View.OnClickListener cliqueBotao1() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(),MainActivity2.class);

                Pessoa p = new Pessoa(nome.getText().toString(), 10);

                itn.putExtra("nome", nome.getText().toString());
                itn.putExtra("idade", 10);
                itn.putExtra("pessoa", p);

                //primeira forma de chamar tela (SEM RETORNO)
                //startActivity(itn);
                startActivityForResult(itn,viewTela2);
            }
        };
    }


    private void binding() {

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        nome = findViewById(R.id.edtNome);

    }
}