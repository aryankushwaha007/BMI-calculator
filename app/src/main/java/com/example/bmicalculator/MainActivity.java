package com.example.bmicalculator;

import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult = findViewById(R.id.txtResult);
        EditText edtWeight=findViewById(R.id.edtWeight);
        EditText edtHeightFt=findViewById(R.id.edtHeightFt);
        EditText edtHeightIn=findViewById(R.id.edtHeightIn);
        Button calculateBtn=findViewById(R.id.calculateBtn);
        LinearLayout llMain=findViewById(R.id.llMain);

        calculateBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
               int wt=Integer.parseInt(edtWeight.getText().toString());
               int ft= Integer.parseInt( edtHeightFt.getText().toString());
               int in=Integer.parseInt(edtHeightIn.getText().toString());


               int totalIn=ft*12+in;
               double totalCm=totalIn*2.53;
               double totalM=totalCm/100;
               double bmi=wt/(totalM*totalM);

               if(bmi > 25){
                   txtResult.setText("You are Overweight");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colorOw));


               } else if (bmi<18) {
                   txtResult.setText("You are Underweight");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
               }else{
                   txtResult.setText("You are Healthy");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colorH));

               }
            }
        });
    }


}