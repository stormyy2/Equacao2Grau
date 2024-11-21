package com.trabalhos.equacao2grau;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText valorA;
    private EditText valorB;
    private EditText valorC;
    private TextView resr1;
    private TextView resr2;
    private TextView resDelta;


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


        valorA = findViewById(R.id.valorA);
        valorB = findViewById(R.id.valorB);
        valorC = findViewById(R.id.valorC);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        resr1 = findViewById(R.id.r1);
        resr1.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        resr2 = findViewById(R.id.r2);
        resr2.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        resDelta = findViewById(R.id.delta);
        resDelta.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        btnCalcular.setOnClickListener(x -> Calcular());
    }

    private void Calcular(){
        int numA = Integer.parseInt(valorA.getText().toString());
        int numB = Integer.parseInt(valorB.getText().toString());
        int numC = Integer.parseInt(valorC.getText().toString());
        double delta = (numB * numB) - (4 * numA * numC);
        double r1 = (-numB + Math.sqrt(delta)) / (2*numA);
        double r2 = (-numB - Math.sqrt(delta)) / (2*numA);

        String raiz1 = getString(R.string.r1) + r1;
        String raiz2 = getString(R.string.r2) + r2;
        String valorDelta = getString(R.string.delta) + delta;

        resr1.setText(raiz1);
        resr2.setText(raiz2);
        resDelta.setText(valorDelta);

    }
}