package com.example.ex10;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText a,b,c;
    Random rnd =new Random();
    TextView result;
    int num_results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = (EditText) findViewById(R.id.editTextNumber);
        b = (EditText) findViewById(R.id.editTextNumber2);
        c = (EditText) findViewById(R.id.editTextNumber3);
        result = (TextView) findViewById(R.id.textView4);
    }

    public void goRandom(View view) {
        a.setText(""+rnd.nextInt(100));
        b.setText(""+rnd.nextInt(100));
        c.setText(""+rnd.nextInt(100));
    }


    public void gotosec(View view) {
        if((a.getText().toString().length() > 0) && (b.getText().toString().length()> 0) && (c.getText().toString().length() > 0)){
            Intent si = new Intent(this,MainActivity2.class);
            si.putExtra("a",a.getText().toString());
            si.putExtra("b",b.getText().toString());
            si.putExtra("c",c.getText().toString());
            startActivityForResult(si,69);
        }
        else
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if (data_back != null) {
            num_results = data_back.getIntExtra("how_many_solution",4);
            if (num_results==0)
                result.setText("There are no solutions to the problem");
            else if (num_results==1)
                result.setText("The solution to the problem is: "+data_back.getDoubleExtra("x1",4));
            else if (num_results==2)
                result.setText("x1="+data_back.getDoubleExtra("x1",4)+
                        ",x2="+data_back.getDoubleExtra("x2",4));
        }
    }
}