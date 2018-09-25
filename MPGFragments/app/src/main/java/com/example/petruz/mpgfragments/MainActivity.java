package com.example.petruz.mpgfragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.petruz.mpgfragments.fragments.ResultFragment;
import com.example.petruz.mpgfragments.fragments.StartFragment;
import com.example.petruz.mpgfragments.models.ResultModel;

public class MainActivity extends AppCompatActivity
{
    //boolean to see which fragment the activity should show
    public static boolean startFragment = true;
    //a static reference to the ResultModel class where all the data is saved
    // I should maybe have made it a singeltone class, but it is the same principle
    public static ResultModel resModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //check if we already have a fragment when rotating screen
        if (savedInstanceState == null)
        {
            resModel = new ResultModel();

            StartFragment start = new StartFragment();
            showFragment(start);
        }

    }

    private void showFragment(Fragment frag)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.fl_fragment_layout, frag)
                .commit();
    }

    public void clickBtn(View view) {

        if(startFragment)
        {
            //if statements to check if the user has put in all the information needed to continue
            if(resModel.getMPG() == 0)
            {
                Toast.makeText(this, "you must put in MPG", Toast.LENGTH_LONG)
                        .show();
                return;
            }

            if(resModel.getGasPrice() == 0)
            {
                Toast.makeText(this, "you must put in a gasprice", Toast.LENGTH_LONG)
                        .show();
                return;
            }

            if(resModel.getMilage() == 0 )
            {
                Toast.makeText(this, "you must put in the length of the trip in miles", Toast.LENGTH_LONG)
                        .show();
                return;
            }
            ResultFragment res = new ResultFragment();
            showFragment(res);
        }
        else
        {
            StartFragment start = new StartFragment();
            showFragment(start);
        }



    }
}
