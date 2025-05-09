package com.example.calculadorafinanceira;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void buttonSimples(View v){
        Intent i = new Intent(MainActivity.this, JurosSimples.class);
        startActivity(i);
    }
    public void buttonComposto(View v){
        Intent i = new Intent(MainActivity.this, JurosCompostos.class);
        startActivity(i);
    }
    public void buttonSite(View v){
        String url = "http://www.calculador.com.br/";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
    }
    public void buttonFuturo(View v){
        Intent i = new Intent(MainActivity.this, ValorFuturo.class);
        startActivity(i);
    }
    public void buttonParcela(View v){
        Intent i = new Intent(MainActivity.this, ValorParcela.class);
        startActivity(i);
    }
}