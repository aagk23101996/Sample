package com.example.user.recycler;

import java.util.Date;

/**
 * Created by user on 01-10-2016.
 */

public class Crime {
    private String crimetitle;
    private boolean ischecked;
    private Date m=new Date();
    public void getstring(String mcrimetitle){
        crimetitle=mcrimetitle;
    }
    public void getischecked(boolean a){
        ischecked=a;
    }
    public String getitle(){
        return crimetitle;
    }
    public Date getdate(){return m;}
    public boolean getcc(){
        return ischecked;
    }



}
