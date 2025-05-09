package com.example.calculadorafinanceira;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ValorParcela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_valor_parcela);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        Button Calcular = findViewById(R.id.buttonParcelas);
        EditText VC = findViewById(R.id.editTextVC);
        EditText TaxaP = findViewById(R.id.editTextTaxaP);
        EditText NumParcela = findViewById(R.id.editTextNumP);
        TextView VT = findViewById(R.id.textViewVT);
        TextView Parcela = findViewById(R.id.textViewP);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Double num1 = Double.parseDouble(VC.getText().toString());
                String taxaStr = TaxaP.getText().toString();
                Double num2 = taxaStr.isEmpty() ? 0.0 :
                        Double.parseDouble(taxaStr);
                Integer num3 = Integer.parseInt(NumParcela.getText().toString());



                Double VF = num1 * Math.pow(1+num2/100, num3);
                Double Prcl = VF / num3;
                Double NoTaxa = num1/num3;
                Log.d("test", TaxaP.getText().toString());


                if (num2!=null){
                    VT.setText(String.format("O valor total a se pagar é de: R$ %.2f", VF));
                    Parcela.setText(String.format("O valor de cada parcela é de: R$ %.2f", Prcl));
                } else {
                    VT.setText(String.format("O valor total a se pagar é de: R$ %.2f", num1));
                    Parcela.setText(String.format("O valor de cada parcela é de: R$ %.2f", NoTaxa));
                }

            }
        });
    }
}