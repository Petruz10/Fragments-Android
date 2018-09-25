package com.example.petruz.mpgfragments.fragments;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.provider.DocumentFile;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.petruz.mpgfragments.MainActivity;
import com.example.petruz.mpgfragments.R;
import com.example.petruz.mpgfragments.models.ResultModel;

/**
 * Created by Petruz on 22/10/17.
 */

public class ResultFragment extends Fragment
{
    private double gasPrice;
    private double MPG;
    private double miles;

    private View v;

    private final String LOGTAG = "resultFragment";

    public ResultFragment()
    {
        MainActivity.startFragment = false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.result_fragment, container, false);

        CheckBox check = (CheckBox) v.findViewById(R.id.cbEco);

        this.gasPrice = MainActivity.resModel.getGasPrice();
        this.MPG  = MainActivity.resModel.getMPG();
        this.miles = MainActivity.resModel.getMilage();

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked)
                {
                    MPG = MPG + 5;
                }
                else
                {
                    MPG = MPG - 5;
                }
                viewResult();

            }
        });
        return v;
    }

    @Override
    public void onStart() {
        viewResult();

        super.onStart();
    }

    private void viewResult()
    {
        double priceMile;
        double totalPrice;

        priceMile = this.gasPrice / this.MPG;
        priceMile = roundTwoDecimals(priceMile);

        totalPrice = priceMile * this.miles;
        totalPrice = roundTwoDecimals(totalPrice);

        TextView totResult = (TextView) v.findViewById(R.id.resTot);
        totResult.setText(getString(R.string.total_price$) + totalPrice);

        TextView mileResult = (TextView) v.findViewById(R.id.resMile);
        mileResult.setText(getString(R.string.price_per_mile$) + priceMile);

    }

    //method to round double numbers to only 2 decimals
    double roundTwoDecimals(double number) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(number));
    }

}
