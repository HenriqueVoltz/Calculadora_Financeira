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

public class ValorFuturo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_valor_futuro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button Button = findViewById(R.id.buttonCalcF);
        EditText VP = findViewById(R.id.editTextVP);
        EditText Taxa = findViewById(R.id.editTextTaxaF);
        EditText Tempo = findViewById(R.id.editTextTempoF);
        TextView Saida = findViewById(R.id.textViewSaidaF);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double num1 = Double.parseDouble(VP.getText().toString());
                Double num2 = Double.parseDouble(Taxa.getText().toString());
                Integer num3 = Integer.parseInt(Tempo.getText().toString());
                Double VF = num1 * Math.pow(1+num2/100, num3);

                Saida.setText(String.format("O valor futoro se seus investimentos será: R$ %.2f", VF));

            }
        });
    }
}