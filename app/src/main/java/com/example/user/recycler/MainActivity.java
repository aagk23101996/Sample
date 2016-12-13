package com.example.user.recycler;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    protected void onCreate(Bundle g){
        super.onCreate(g);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        BlankFragment t=new BlankFragment();
        ft.replace(R.id.frame,t);
        ft.commit();

    }

}