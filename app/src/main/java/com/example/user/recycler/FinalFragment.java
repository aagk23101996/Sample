package com.example.user.recycler;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FinalFragment extends Fragment {
    private static String yy=null;
    private int r;
    private View view;
    private String hh="Hi";
    private int REQ_CODE=0;
    private String fr="ghg";
    CrimeLab lab=new CrimeLab();
    private Date y=new Date();
    private Button br;
    private List<Crime> arr=lab.crimee();


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstance){

        r=getArguments().getInt(yy);

        final Crime cr=arr.get(r);
        view=inflater.inflate(R.layout.fragment_final, container, false);
br=(Button)view.findViewById(R.id.butt1);
        br.setText(y.toString());
        br.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Dialogs tr=new Dialogs();
                FragmentManager rt=getFragmentManager();
                tr.setTargetFragment(FinalFragment.this,REQ_CODE);
                tr.show(rt,fr);
            }
        });

        EditText you=(EditText)view.findViewById(R.id.txt);
        you.setText(cr.getitle());
        you.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cr.getstring(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }
    public static Fragment newInstance(int gg){
        Bundle bundle=new Bundle();
        bundle.putInt(yy,gg);
        FinalFragment t=new FinalFragment();
        t.setArguments(bundle);



        return t;
    }
public void onActivityResult(int REQs_CODE, int RES_CODE, Intent h){
    if((REQs_CODE==REQ_CODE)&&(RES_CODE== Activity.RESULT_OK)){
        Date dates=(Date)h.getExtras().get(hh);
        br.setText(dates.toString());

    }
}


}
