package com.example.gloss;

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

public class MainActivity extends AppCompatActivity {
    EditText inputA;
    EditText inputB;
    Button oblicz;
    TextView wynik;
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

        inputA = findViewById(R.id.inputA);
        inputB = findViewById(R.id.inputB);
        oblicz = findViewById(R.id.oblicz);
        wynik = findViewById(R.id.wynik);

        oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = inputA.getText().toString();
                String s2 = inputB.getText().toString();
                int l1 = Integer.parseInt(s1);
                int l2 = Integer.parseInt(s2);
                
                wynik.setText(s1 + s2);

            }
        });

    }
}