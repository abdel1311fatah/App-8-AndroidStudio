//Abel Ibarra

package com.example.app8_2023_24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// ficar el layout weight a 2 per a que s ajusti be

public class MainActivity extends AppCompatActivity {

    private TextView appname;
    private TextView resultat;
    private Button reset;
    private Button sumar;
    private Button restar;
    private Button multi;
    private Button div;
    private Button igual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appname = (TextView) findViewById(R.id.appname);
        appname.setText("App8_2023_24");
        resultat = (TextView) findViewById(R.id.resultat);
        reset = (Button) findViewById(R.id.btnReset);
        sumar = (Button) findViewById(R.id.btnSuma);
        restar = (Button) findViewById(R.id.btnResta);
        multi = (Button) findViewById(R.id.btnMulti);
        div = (Button) findViewById(R.id.btnDiv);
        igual = (Button) findViewById(R.id.btnIgual);
    }

    public void numeros(View view) {

        Button btn = (Button) view;
        resultat.setText(resultat.getText().toString() + btn.getText().toString());

    }

    public void operadors(View view) {

        Button btn = (Button) view;

        if (!(resultat.getText().toString().contains("+") || resultat.getText().toString().contains("-") || resultat.getText().toString().contains("*") || resultat.getText().toString().contains("/"))) {
            resultat.setText(resultat.getText().toString() + btn.getText().toString());
        } else {
            char[] texte = new char[resultat.getText().toString().length()];
            texte = resultat.getText().toString().toCharArray();
            for (int i = 0; i < resultat.getText().toString().length(); i++) {
                if(texte[i] == '+' || texte[i] == '-' || texte[i] == '*' || texte[i] == '/'){
                    texte[i] = btn.getText().toString().charAt(0);
                }
            }
        }

    }

}