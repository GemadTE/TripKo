package com.example.gdte.tripko.contactosdeinteres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Contactos_De_InteresActivity
        extends AppCompatActivity implements Contactos_De_InteresContract.View {

    public static String TAG = Contactos_De_InteresActivity.class.getSimpleName();

    private Contactos_De_InteresContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos__de__interes);

        // do the setup
        Contactos_De_InteresScreen.configure(this);

        if (savedInstanceState == null) {
            presenter.onStart();

        } else {
            presenter.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        presenter.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

    @Override
    public void onDataUpdated(Contactos_De_InteresViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
       // ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(Contactos_De_InteresContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
