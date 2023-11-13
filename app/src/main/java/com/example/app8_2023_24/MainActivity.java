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
                if (texte[i] == '+' || texte[i] == '-' || texte[i] == '*' || texte[i] == '/') {
                    texte[i] = btn.getText().toString().charAt(0);
                }
            }
        }

    }

    public void igual(View view) {
        String expresion = resultat.getText().toString();

        if (expresion.contains("+")) {
            realitzarOperacio(expresion, '+');
        } else if (expresion.contains("-")) {
            realitzarOperacio(expresion, '-');
        } else if (expresion.contains("*")) {
            realitzarOperacio(expresion, '*');
        } else if (expresion.contains("/")) {
            realitzarOperacio(expresion, '/');
        } else {
           resultat.setText("No hi ha operador");
        }
    }

    private void realitzarOperacio(String expresion, char operador) {
        String operadorString = Character.toString(operador);
        String[] numeros = expresion.split(operadorString);
        long resultatOperacio = 0;

        if (numeros.length != 2) {
            resultat.setText("Error in the mathematical expression");
        } else {
            long n1 = Integer.parseInt(numeros[0].trim()); // Per treure els espais en blanc
            long n2 = Integer.parseInt(numeros[1].trim());

            switch (operador) {
                case '+':
                    resultatOperacio = n1 + n2;
                    break;
                case '-':
                    resultatOperacio = n1 - n2;
                    break;
                case '*':
                    resultatOperacio = n1 * n2;
                    break;
                case '/':
                    if (n2 != 0) {
                        resultatOperacio = n1 / n2;
                    } else {
                        resultat.setText("Cannot divide by 0");
                        return;
                    }
                    break;
            }
            resultat.setText(String.valueOf(resultatOperacio));
        }
    }

    public void reset(View view){

        resultat.setText("");

    }

}