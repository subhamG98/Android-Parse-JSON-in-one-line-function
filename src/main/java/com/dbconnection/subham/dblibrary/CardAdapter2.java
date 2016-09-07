package com.dbconnection.subham.dblibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Belal on 10/29/2015.
 */
public class CardAdapter2 extends RecyclerView.Adapter<CardAdapter2.ViewHolder> {

    List<ListItem> items;
    Integer v11;
    String[] b11;
    String tag1;
    Context c2;
    public CardAdapter2(ArrayList<String> a1, ArrayList<String> a2, String[] b1, Integer v12,Context c1){
        super();
        items = new ArrayList<ListItem>();
        v11=v12;
        b11=b1;
        c2=c1;



        for(int i =0; i<a1.size(); i++){
            ListItem item = new ListItem();
            item.setp1(a1.get(i));
            item.setp2(a2.get(i));


            items.add(item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        String s="R.layout.list_card_view";

        View v = LayoutInflater.from(parent.getContext())
                .inflate(v11, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem list =  items.get(position);
        if(b11[0].contains("text")) {
            holder.t1.setText(list.getp1());
        }
        if(b11[0].contains("image")){
            Picasso.with(c2).load(""+list.getp1()).into(holder.i1);
        }


        if(b11[1].contains("text")) {
            holder.t2.setText(list.getp2());
        }
        if (b11[1].contains("image")){
            Picasso.with(c2).load(""+list.getp2()).into(holder.i2);
        }



    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView t1,t2;
        public ImageView i1,i2;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);

            if(b11[0].contains("text")) {
                t1 = (TextView) itemView.findViewById(R.id.p1);
            }
            if(b11[0].contains("image")) {
                i1 = (ImageView) itemView.findViewById(R.id.p1);
            }

            if(b11[1].contains("text")) {
                t2 = (TextView) itemView.findViewById(R.id.p2);
            }
            if(b11[1].contains("image")) {
                i2 = (ImageView) itemView.findViewById(R.id.p2);
            }


        }
    }
}