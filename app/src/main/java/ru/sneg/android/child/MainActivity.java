package ru.sneg.android.child;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int countFamily = 0;
    private int countChild = 0;



    public void btnFamily(View view) {

        displayFam(++countFamily);

        if (countFamily == 6) {
            displayFam(0);
            countFamily = 0;
        }

    }
    public void btnChild(View view) {

        displayChild(++countChild);

        if (countChild == 5) {
            displayChild(0);
            countChild = 0;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btnOrder(View view){
        EditText inputEditText1 = (EditText) findViewById(R.id.editText);

        if (inputEditText1.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Введите стоимость картиры",
                    Toast.LENGTH_LONG).show();
            return;
        }

        EditText inputEditText2 = (EditText) findViewById(R.id.editText2);

        if (inputEditText2.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Введите сумму сертификата",
                    Toast.LENGTH_LONG).show();
            return;
        }

    }



    private void displayFam(int countFamily) {
        TextView quantityTextView = findViewById(R.id.textView2);
        quantityTextView.setText("x" + countFamily);
    }

    private void displayChild(int countChild) {
        TextView quantityTextView =  findViewById(R.id.textView);
        quantityTextView.setText("x" + countChild);
    }







}
