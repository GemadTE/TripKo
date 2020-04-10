package com.example.gdte.tripko.cultura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class CulturaActivity
        extends AppCompatActivity implements CulturaContract.View {

    public static String TAG = CulturaActivity.class.getSimpleName();

    private CulturaContract.Presenter presenter;
    private ImageButton preguntasFrecuentesImageButton, homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultura);

        // do the setup
        CulturaScreen.configure(this);
        preguntasFrecuentesImageButton=findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton=findViewById(R.id.homeImageButton);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(CulturaViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(CulturaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
