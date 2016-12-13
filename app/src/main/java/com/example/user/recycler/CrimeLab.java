package com.example.user.recycler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 01-10-2016.
 */

public class CrimeLab {
   static List<Crime> u=new ArrayList<Crime>();

    public  static List<Crime> crimee(){


            return u;


    }
    public CrimeLab(){

            Crime crime=new Crime();

            u.add(crime);


    }




}
