package com.example.gdte.tripko.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;


import com.example.gdte.tripko.R;
import com.example.gdte.tripko.elegiridioma.Elegir_IdiomaActivity;

public class SplashActivity
        extends AppCompatActivity implements SplashContract.View {

    public static String TAG = SplashActivity.class.getSimpleName();

    private SplashContract.Presenter presenter;

    private final int DURACION_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                presenter.goChooseLanguage();
                finish();
            }

            ;
        }, DURACION_SPLASH);
        // do the setup
        SplashScreen.configure(this);
    }

    @Override
    public void navigateToChooseLanguageScreen() {
        Intent intent = new Intent(this, Elegir_IdiomaActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(SplashContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
