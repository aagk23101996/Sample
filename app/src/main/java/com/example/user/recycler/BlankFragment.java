package com.example.user.recycler;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BlankFragment extends Fragment{
    private RecyclerView r;
    private CrimeLab j=new CrimeLab();
    private List<Crime> f=j.crimee();
    private static int position=0;
    private CrimeAdapter madapter;
    private int d;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle g){
        View view=inflater.inflate(R.layout.fragment_blank,container,false);
        r= (RecyclerView) view.findViewById(R.id.recycle);
        r.setLayoutManager(new LinearLayoutManager(getActivity()));

        setHasOptionsMenu(true);
        return view;
    }

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView t1;
        CheckBox r;
        TextView t2;

        public CrimeHolder(View itemView) {
            super(itemView);
             r=(CheckBox)itemView.findViewById(R.id.check);
             t1=(TextView)itemView.findViewById(R.id.txt1);
             t2=(TextView)itemView.findViewById(R.id.txt2);
            itemView.setOnClickListener(this);

        }



        @Override
        public void onClick(View v) {
 String yy="hello";
             d=getLayoutPosition();
            Intent intent=viewpager.getIntentt(getActivity(),d);
            startActivity(intent);

        }
    }
    public void onResume(){
        super.onResume();
        updateUI();
    }
    public boolean onOptionsItemSelected(MenuItem menu){
        switch (menu.getItemId()){
            case R.id.gh:
                new CrimeLab();
                Intent intent=viewpager.getIntentt(getActivity(),d+1);
                startActivity(intent);
        }
        return true;
    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater g){
        super.onCreateOptionsMenu(menu,g);
        g.inflate(R.menu.menuu,menu);
    }
    public void updateUI(){
        if(madapter==null){
            madapter=new CrimeAdapter();
            r.setAdapter(madapter);
        }
        else
            madapter.notifyDataSetChanged();
    }
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater y=LayoutInflater.from(getActivity());
            View v=y.inflate(R.layout.uselayout,parent,false);
            return new CrimeHolder(v);

        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime=f.get(position);
            holder.t1.setText(crime.getitle());
            holder.t2.setText(crime.getdate().toString());
            holder.r.setChecked(crime.getcc());

        }

        @Override
        public int getItemCount() {
            return f.size();
        }
    }
}