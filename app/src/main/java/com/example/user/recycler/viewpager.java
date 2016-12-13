package com.example.user.recycler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class viewpager extends AppCompatActivity{
    private static String u="Hello";
    private String stack;
    CrimeLab labs=new CrimeLab();
    private int f;
    private List<Crime> rrrr=labs.crimee();
    public void onCreate(Bundle g){
        super.onCreate(g);
        setContentView(R.layout.activity_viewpager);

        Log.d(stack,"Outside createFragment");

        Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.yyy);
        if(fragment==null){
            fragment=createFragment();
            FragmentTransaction rry=getSupportFragmentManager().beginTransaction();
            rry.replace(R.id.yyy,fragment);
            rry.commit();
        }
        ViewPager tr=(ViewPager)findViewById(R.id.yyy);
        FragmentManager rt=getSupportFragmentManager();
        tr.setAdapter(new FragmentStatePagerAdapter(rt) {
            @Override
            public Fragment getItem(int position) {
              return FinalFragment.newInstance(position);
            }

            @Override
            public int getCount() {
                return rrrr.size();
            }
        });
        tr.setCurrentItem(f);


    }
    public static Intent getIntentt(Context context, int y){
        Intent r=new Intent(context,viewpager.class);
        r.putExtra(u,y);

        return r;
    }

protected Fragment createFragment(){
     f=(int)getIntent().getExtras().get(u);

Log.d(stack,"Inside createFragment");
    return FinalFragment.newInstance(f);
}
}