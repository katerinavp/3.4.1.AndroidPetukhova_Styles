package com.example.a341androidpetukhova_styles;

import androidx.appcompat.app.AppCompatActivity;


import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner languageSpinner;
    private Button btnOK;
    private Spinner colorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        initViews();
        initSpinnerLanguage();
        initSpinnerColor();

    }

    private void initViews() {
        languageSpinner = findViewById(R.id.languageSpinner);
        btnOK = findViewById(R.id.btnOK);
        colorSpinner = findViewById(R.id.colorSpinner);

    }

    private void initSpinnerLanguage() {
        ArrayAdapter<CharSequence> adapterLanguage = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapterLanguage);


        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] languages = getResources().getStringArray(R.array.language);

                setOnClickBtnLanguage(languages[i]);
            }

            @Override
            public void onNothingSelected(AdapterView parent) {
            }
        });

    }

    private void initSpinnerColor() {
        ArrayAdapter<CharSequence> adapterColor = ArrayAdapter.createFromResource(this, R.array.color, android.R.layout.simple_spinner_item);
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(adapterColor);

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] colors = getResources().getStringArray(R.array.color);

                setOnClickBtnColor(colors[i]);
            }

            @Override
            public void onNothingSelected(AdapterView parent) {
            }
        });

    }

    private void setOnClickBtnLanguage(final String lang) {
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (lang) {
                    case "Английский":
                        Locale localeEn = new Locale("en");
                        Configuration configEn = new Configuration();
                        configEn.setLocale(localeEn);
                        getResources().updateConfiguration(configEn, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                        return;
                    case "Russian":
                        Locale localeRu = new Locale("ru");
                        Configuration configRu = new Configuration();
                        configRu.setLocale(localeRu);
                        getResources().updateConfiguration(configRu, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                        return;

                }
            }
        });
    }

    private void setOnClickBtnColor(final String colors) {
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (colors) {
                    case "Green":
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                        break;
                    case "Зеленый":
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                        break;
                    case "Black":
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLACK);
                        break;
                    case "Черный":
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLACK);
                        break;
                    case "Blue":
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                        break;
                    case "Синий":
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                        break;
                }
            }

        });

    }
}




