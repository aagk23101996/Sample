package com.example.user.recycler;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Dialogs extends DialogFragment{
    Date date=new Date();
    Calendar calendar=Calendar.getInstance();
    private  String hh="Hi";
    private int RES_CODE= Activity.RESULT_OK;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater infh=LayoutInflater.from(getActivity());
        calendar.setTime(date);
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        View f=infh.inflate(R.layout.mylay,null);
        final DatePicker pick=(DatePicker)f.findViewById(R.id.ddt);
        pick.init(year,month,day,null);

        AlertDialog.Builder r=new AlertDialog.Builder(getActivity());
        r.setView(f);
        r.setTitle(R.string.date_picker_title);
        r.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int year=pick.getYear();
                int month=pick.getMonth();
                int day=pick.getDayOfMonth();
                Date dt=new GregorianCalendar(year,month,day).getTime();
                Intent in=new Intent();
                in.putExtra(hh,dt);
                getTargetFragment().onActivityResult(getTargetRequestCode(),RES_CODE,in);

            }
        });

        return r.create();
    }
}


