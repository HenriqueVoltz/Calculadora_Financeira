package com.example.calculadorafinanceira;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JurosCompostos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_juros_compostos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button Calcular = findViewById(R.id.buttonJurosC);
        EditText Capital = findViewById(R.id.editTextCapitalC);
        EditText Juros = findViewById(R.id.editTextTaxaC);
        EditText Tempo = findViewById(R.id.editTextTempoC);
        TextView Saida = findViewById(R.id.textViewSaida1);
        TextView Saida2 = findViewById(R.id.textViewSaida2);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double num1 = Double.parseDouble(Capital.getText().toString());
                Double num2 = Double.parseDouble(Juros.getText().toString());
                Integer num3 = Integer.parseInt(Tempo.getText().toString());
                Double Montante = num1 * Math.pow(1+num2/100, num3);
                Double Final = Montante - num1;

                Saida.setText(String.format("Seu Montante é de: R$ %.2f", Montante));
                Saida2.setText(String.format("Seus juros foram de: R$ %.2f", Final));
            }
        });

        }
}