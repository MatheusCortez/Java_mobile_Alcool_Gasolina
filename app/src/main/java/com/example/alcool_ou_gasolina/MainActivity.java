package com.example.alcool_ou_gasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool,editPrecoGasolina,editKmAlcool,editKmGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editPrecoAlcool= findViewById(R.id.editPrecoAlcool);
        editKmAlcool= findViewById(R.id.editTextKmAlcool);
        editPrecoGasolina= findViewById(R.id.editPrecoGasolina);
        editKmGasolina=findViewById(R.id.editTextKmGasolina);
        textResultado = findViewById(R.id.textResultado);

    }

    public void  calcularPreco(View view){

        String precoAlcool =editPrecoAlcool.getText().toString();
        String precoGasolina =editPrecoGasolina.getText().toString();
        Double kmAlcool = Double.parseDouble(String.valueOf(editKmAlcool.getText()));
        Double kmGasolina = Double.parseDouble(String.valueOf(editKmGasolina.getText()));

        Double diferencaKm = (kmGasolina-kmAlcool);



        Boolean camposValidados =validarCampos(precoAlcool,precoGasolina);

        if(camposValidados){

          Double  valorAlcool=Double.parseDouble(precoAlcool);
          Double  valorGasolina=Double.parseDouble(precoGasolina);
            Double diferencaValor =valorAlcool/valorGasolina;
          if (diferencaValor<=0.7 && diferencaKm>=0.7){
            textResultado.setText("Recomendado usar gasolina ");
          }else if(diferencaValor>=0.7 && diferencaKm<=0.7) {
              textResultado.setText("Recomendado usar alcool ");

          }else if(diferencaValor<=0.7 && diferencaKm<=0.7 ){
              textResultado.setText("Recomendado usar alcool ");

          }else{
              textResultado.setText("Recomendado usar Gasolina ");
          }



        }else{
            textResultado.setText("Preencha os campos primeiro");
        }

    }

    public  Boolean validarCampos(String pAlcool,String pGasolina){
        Boolean camposValidados=true;

        if(pAlcool==null || pAlcool.equals("")|| pGasolina==null||pGasolina.equals("")){

            camposValidados = false;
        }
        return camposValidados;
    }
}