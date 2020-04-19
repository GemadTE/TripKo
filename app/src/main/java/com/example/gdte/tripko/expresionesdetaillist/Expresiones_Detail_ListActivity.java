package com.example.gdte.tripko.expresionesdetaillist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Expresiones_Detail_ListActivity
        extends AppCompatActivity implements Expresiones_Detail_ListContract.View {

    public static String TAG = Expresiones_Detail_ListActivity.class.getSimpleName();

    private Expresiones_Detail_ListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expresiones__detail__list);

        // do the setup
        Expresiones_Detail_ListScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(Expresiones_Detail_ListViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(Expresiones_Detail_ListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
