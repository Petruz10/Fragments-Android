package com.example.petruz.mpgfragments.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.petruz.mpgfragments.MainActivity;
import com.example.petruz.mpgfragments.R;
import com.example.petruz.mpgfragments.models.ResultModel;

/**
 * Created by Petruz on 22/10/17.
 */

public class StartFragment extends Fragment
{

    public StartFragment()
    {
        MainActivity.startFragment = true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        //setting everything to zero so in the resModel so it won't get old numbers in the resultFragment
        MainActivity.resModel.setGasPrice(0);
        MainActivity.resModel.setMPG(0);
        MainActivity.resModel.setMilage(0);

        View v = inflater.inflate(R.layout.start_fragment, container, false);

        EditText gasPriceET = (EditText) v.findViewById(R.id.et_gaspriceGallon);
        EditText milageET = (EditText) v.findViewById(R.id.et_length);
        EditText MPGET = (EditText) v.findViewById(R.id.et_milage);

        gasPriceET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                if(editable.toString().isEmpty()) return;
                double gasPrice = Double.valueOf(editable.toString());
                MainActivity.resModel.setGasPrice(gasPrice);
            }
        });

        milageET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().isEmpty()) return;
                double milage = Double.valueOf(editable.toString());
                MainActivity.resModel.setMilage(milage);
            }
        });

        MPGET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().isEmpty()) return;
                double MPG = Double.valueOf(editable.toString());
                MainActivity.resModel.setMPG(MPG);
            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {

        super.onPause();
    }

    @Override
    public void onStop() {

        super.onStop();
    }
}
