package ru.sneg.android.child;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int countFamily = 0;
    private int countChild = 0;
    private float flatCoast = 0;
    private float matCap = 0;


    public void btnFamily(View view) {
        displayFam(++countFamily);
        if (countFamily == 6) {
            displayFam(1);
            countFamily = 1;
        }
        // анимация нажатия кнопки (уменьшение)
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.scale);
        view.startAnimation(animAlpha);
    }


    public void btnChild(View view) {
        displayChild(++countChild);
        if (countChild == 5) {
            displayChild(1);
            countChild = 1;
        }
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.scale);
        view.startAnimation(animAlpha);
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
        // считывание сумм квартиры и сертификата с EditText(ов)
        flatCoast = Float.parseFloat(inputEditText1.getText().toString());
        matCap = Float.parseFloat(inputEditText2.getText().toString());



        float childPart = (matCap/flatCoast/countFamily);
        displayChildPart(childPart);

        float sharedParentsPart = (1 - childPart*countChild);
        displaySharedParentsPart(sharedParentsPart);

    }

    private void displayFam(int countFamily) {
        TextView quantityTextView = findViewById(R.id.textView2);
        quantityTextView.setText("x" + countFamily);
    }

    private void displayChild(int countChild) {
        TextView quantityTextView =  findViewById(R.id.textView);
        quantityTextView.setText("x" + countChild);
    }

    private void displayChildPart(float childPart) {
        TextView quantityTextView =  findViewById(R.id.textView4);
        quantityTextView.setText("" + childPart);
    }

    private void displaySharedParentsPart(float sharedParentsPart) {
        TextView quantityTextView =  findViewById(R.id.textView6);
        quantityTextView.setText("" + sharedParentsPart);
    }







}
