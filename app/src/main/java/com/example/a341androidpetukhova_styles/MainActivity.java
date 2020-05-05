package com.example.a341androidpetukhova_styles;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner languageSpinner;
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
        colorSpinner = findViewById(R.id.colorSpinner);

        Button btnOK = findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] languages = getResources().getStringArray(R.array.language);
                int i = languageSpinner.getSelectedItemPosition();
                switch (languages[i]) {
                    case "Английский":
                        Locale localeEn = new Locale("en");
                        Configuration configEn = new Configuration();
                        configEn.setLocale(localeEn);
                        getResources().updateConfiguration(configEn, getBaseContext().getResources().getDisplayMetrics());
                        break;
                    case "Russian":
                        Locale localeRu = new Locale("ru");
                        Configuration configRu = new Configuration();
                        configRu.setLocale(localeRu);
                        getResources().updateConfiguration(configRu, getBaseContext().getResources().getDisplayMetrics());
                        break;
                }

                String[] colors = getResources().getStringArray(R.array.color);
                int j = colorSpinner.getSelectedItemPosition();
                switch (colors[j]) {
                    case "Green":
                    case "Зеленый":
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                        break;
                    case "Black":
                    case "Черный":
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLACK);
                        break;
                    case "Blue":
                    case "Синий":
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                        break;
                }
            }
        });

    }


    private void initSpinnerLanguage() {
        ArrayAdapter<CharSequence> adapterLanguage = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapterLanguage);

    }

    private void initSpinnerColor() {
        ArrayAdapter<CharSequence> adapterColor = ArrayAdapter.createFromResource(this, R.array.color, android.R.layout.simple_spinner_item);
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(adapterColor);

    }

}



