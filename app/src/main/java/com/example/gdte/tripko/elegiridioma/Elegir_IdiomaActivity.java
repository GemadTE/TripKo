package com.example.gdte.tripko.elegiridioma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Elegir_IdiomaActivity
        extends AppCompatActivity implements Elegir_IdiomaContract.View {

    public static String TAG = Elegir_IdiomaActivity.class.getSimpleName();

    private Elegir_IdiomaContract.Presenter presenter;

    ImageButton spanishButton,englishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_idioma);

        spanishButton = findViewById(R.id.spanishButton);
        englishButton = findViewById(R.id.englishButton);


        spanishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goMenuButtonClicked();
            }
        });

//        englishButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////            }
////        });

        // do the setup
        Elegir_IdiomaScreen.configure(this);
    }

    @Override
    public void injectPresenter(Elegir_IdiomaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
