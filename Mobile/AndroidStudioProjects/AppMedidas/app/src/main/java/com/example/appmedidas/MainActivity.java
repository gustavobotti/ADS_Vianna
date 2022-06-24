package com.example.appmedidas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appmedidas.model.Pessoa;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText campoNome, campoIdade, campoAltura, campoPeso;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (Integer.parseInt(campoIdade.getText().toString()) < 18) {
                        Snackbar.make(getCurrentFocus(), "Não é possível calcular" + " o imc de menor de idade", Snackbar.LENGTH_SHORT).show();
                        return;
                    }
                }catch (NumberFormatException e){
                    Snackbar.make(getCurrentFocus(), " digite uma idade correta", Snackbar.LENGTH_SHORT).show();
                    campoIdade.requestFocus();
                    return;
                }

                Pessoa p = new Pessoa();
                p.setNome( campoNome.getText().toString());
                p.setIdade( Integer.parseInt( campoIdade.getText().toString()));
                p.setAltura( Double.parseDouble( campoAltura.getText().toString()));
                p.setPeso( Double.parseDouble( campoPeso.getText().toString()));


                Toast.makeText(getApplicationContext(), "Olá "+campoNome.getText()+" ("+campoIdade.getText()+" anos). Seu IMC é: "+p.imc()+". Isso significa que você está no nível: "+p.resultado(),
                        Toast.LENGTH_LONG).show();

                cleanField(campoNome,campoAltura,campoIdade,campoPeso);

                campoNome.requestFocus();
            }
        });
    }

    private void cleanField(EditText ... campos) {
        for (EditText et: campos){
            et.setText("");
        }
    }

    private void binding() {
        campoNome = findViewById(R.id.editarNome);
        campoIdade = findViewById(R.id.editarIdade);
        campoAltura = findViewById(R.id.editarAltura);
        campoPeso = findViewById(R.id.editarPeso);
        btn = findViewById(R.id.btnCalcular);
    }
}