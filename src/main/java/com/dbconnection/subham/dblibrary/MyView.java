package com.dbconnection.subham.dblibrary;

/**
 * Created by my pc on 05-09-2016.
 */


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MyView extends LinearLayout {

    private static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView.Adapter adapter;
    private static ViewGroup v1;
    private static Integer v12;



    private static String URL1;
    private static String[] tagnames1;
    private static String[] tagtypes1;
    private static String arrayname1;
    private static Integer taglength;
    static ArrayList<String> a1=new ArrayList<String>();
    static ArrayList<String> a2=new ArrayList<String>();
    static ArrayList<String> a3=new ArrayList<String>();
    static ArrayList<String> a4=new ArrayList<String>();
    static ArrayList<String> a5=new ArrayList<String>();
    static ArrayList<String> a6=new ArrayList<String>();
    static ArrayList<String> a7=new ArrayList<String>();
    static ArrayList<String> a8=new ArrayList<String>();
    static ArrayList<String> a9=new ArrayList<String>();
    static ArrayList<String> a10=new ArrayList<String>();


    static Context c1;


    public MyView(Context context) {
        super(context);
        initialize(context);

    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    private void initialize(Context context){
        inflate(context, R.layout.my_view, this);

        c1=context;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(context);

        recyclerView.setLayoutManager(layoutManager);


    }

   public static void setinputdata(String url,String arrayname,String[] tagnames,String[] tagtypes,Integer v){
       URL1=url;
       tagnames1=tagnames;
       arrayname1=arrayname;

       taglength=tagnames1.length;
       tagtypes1=tagtypes;
       v12=v;


       getData();
   }




    public static void getData(){
        class GetData extends AsyncTask<Void,Void,String>{
         //   ProgressDialog progressDialog;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
             //   progressDialog = ProgressDialog.show(context, "Fetching Data", "Please wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
            //    progressDialog.dismiss();
                parseJSON(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                BufferedReader bufferedReader = null;
                try {
                    Log.i("checkurl",URL1);
                    URL url = new URL(URL1);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while((json = bufferedReader.readLine())!= null){
                        sb.append(json+"\n");
                    }

                    return sb.toString().trim();

                }catch(Exception e){
                    return null;
                }
            }
        }
        GetData gd = new GetData();
        gd.execute();
    }

   public static void showData(){
       if(taglength==1) {
           adapter = new CardAdapter1(a1,tagtypes1,v12,c1);
           recyclerView.setAdapter(adapter);
       }
       if(taglength==2) {
           adapter = new CardAdapter2(a1,a2,tagtypes1,v12,c1);
           recyclerView.setAdapter(adapter);
       }
       if(taglength==3) {
           adapter = new CardAdapter3(a1,a2,a3,tagtypes1,v12,c1);
           recyclerView.setAdapter(adapter);
       }
      if(taglength==4) {
           adapter = new CardAdapter4(a1,a2,a3,a4,tagtypes1,v12,c1);
           recyclerView.setAdapter(adapter);
       }
       if(taglength==5) {
           adapter = new CardAdapter5(a1,a2,a3,a4,a5,tagtypes1,v12,c1);
           recyclerView.setAdapter(adapter);
       }
     /*  if(taglength==6) {
           adapter = new CardAdapter6(a1,a2,a3,a4,a5,a6,tagtypes1,v12);
           recyclerView.setAdapter(adapter);
       }
       if(taglength==7) {
           adapter = new CardAdapter7(a1,a2,a3,a4,a5,a6,a7,tagtypes1,v12);
           recyclerView.setAdapter(adapter);
       }
       if(taglength==8) {
           adapter = new CardAdapter8(a1,a2,a3,a4,a5,a6,a7,a8,tagtypes1,v12);
           recyclerView.setAdapter(adapter);
       }
       if(taglength==9) {
           adapter = new CardAdapter9(a1,a2,a3,a4,a5,a6,a7,a8,a9,tagtypes1,v12);
           recyclerView.setAdapter(adapter);
       }

       if(taglength==10) {
           adapter = new CardAdapter10(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,tagtypes1,v12);
           recyclerView.setAdapter(adapter);
       }
*/




   }


    public static void parseJSON(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            Log.i("jsonarrayr","is-"+json);
            JSONArray array = jsonObject.getJSONArray(arrayname1);


            for(int i=0; i<array.length(); i++){
                    JSONObject j = array.getJSONObject(i);
                    if(taglength==1) {

                        a1.add(j.getString(tagnames1[0]));
                    }
                if(taglength==2) {
                    a1.add(j.getString(tagnames1[0]));
                    a2.add(j.getString(tagnames1[1]));
                }

                if(taglength==3) {


                    a1.add(j.getString(tagnames1[0]));
                    a2.add(j.getString(tagnames1[1]));
                    a3.add(j.getString(tagnames1[2]));

                }

                if(taglength==4) {

                    a1.add(j.getString(tagnames1[0]));
                    a2.add(j.getString(tagnames1[1]));
                    a3.add(j.getString(tagnames1[2]));
                    a4.add(j.getString(tagnames1[3]));


                }
                if(taglength==5) {

                    a1.add(j.getString(tagnames1[0]));
                    a2.add(j.getString(tagnames1[1]));
                    a3.add(j.getString(tagnames1[2]));
                    a4.add(j.getString(tagnames1[3]));
                    a5.add(j.getString(tagnames1[4]));

                }
                if(taglength==6) {

                    a1.add(j.getString(tagnames1[0]));
                    a2.add(j.getString(tagnames1[1]));
                    a3.add(j.getString(tagnames1[2]));
                    a4.add(j.getString(tagnames1[3]));
                    a5.add(j.getString(tagnames1[4]));
                    a6.add(j.getString(tagnames1[5]));

                }
                if(taglength==7) {

                    a1.add(j.getString(tagnames1[0]));
                    a2.add(j.getString(tagnames1[1]));
                    a3.add(j.getString(tagnames1[2]));
                    a4.add(j.getString(tagnames1[3]));
                    a5.add(j.getString(tagnames1[4]));
                    a6.add(j.getString(tagnames1[5]));
                    a7.add(j.getString(tagnames1[6]));



                }
                if(taglength==8) {


                    a1.add(j.getString(tagnames1[0]));
                    a2.add(j.getString(tagnames1[1]));
                    a3.add(j.getString(tagnames1[2]));
                    a4.add(j.getString(tagnames1[3]));
                    a5.add(j.getString(tagnames1[4]));
                    a6.add(j.getString(tagnames1[5]));
                    a7.add(j.getString(tagnames1[6]));
                    a8.add(j.getString(tagnames1[7]));

        }
                if(taglength==9) {

                    a1.add(j.getString(tagnames1[0]));
                    a2.add(j.getString(tagnames1[1]));
                    a3.add(j.getString(tagnames1[2]));
                    a4.add(j.getString(tagnames1[3]));
                    a5.add(j.getString(tagnames1[4]));
                    a6.add(j.getString(tagnames1[5]));
                    a7.add(j.getString(tagnames1[6]));
                    a8.add(j.getString(tagnames1[7]));
                    a9.add(j.getString(tagnames1[8]));


                }
                if(taglength==10) {

                    a1.add(j.getString(tagnames1[0]));
                    a2.add(j.getString(tagnames1[1]));
                    a3.add(j.getString(tagnames1[2]));
                    a4.add(j.getString(tagnames1[3]));
                    a5.add(j.getString(tagnames1[4]));
                    a6.add(j.getString(tagnames1[5]));
                    a7.add(j.getString(tagnames1[6]));
                    a8.add(j.getString(tagnames1[7]));
                    a9.add(j.getString(tagnames1[8]));
                    a10.add(j.getString(tagnames1[9]));


                }



            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    showData();
    }


}
