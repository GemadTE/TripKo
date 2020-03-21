package com.example.gdte.tripko.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.gdte.tripko.R;

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
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(SplashViewModel viewModel) {
        //Log.e(TAG, "displayData()");
    }

    @Override
    public void injectPresenter(SplashContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
