package com.example.pc.robabikia.Categories;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pc.robabikia.R;
import com.example.pc.robabikia.model.News;
import com.example.pc.robabikia.recyclerviewadapter.NewsAdapter;
import com.example.pc.robabikia.utils.Connector;
import com.example.pc.robabikia.utils.Constants;
import com.example.pc.robabikia.utils.Helpers;

import org.json.JSONException;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SportsFragment extends Fragment {

    public NewsAdapter newsAdapter;
    public ArrayList<News> news;
    public ProgressDialog sdialog;

    public SportsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View veiw=inflater.inflate(R.layout.recyclerviewnews  , container, false);
        news =new ArrayList<>();
        RecyclerView recyclerView= (RecyclerView) veiw.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        newsAdapter = new NewsAdapter(this.getActivity(),news);
/*progrssDialog intialization*/

        sdialog=new ProgressDialog(getActivity());
        sdialog.setMessage("Loading...");
        sdialog.setTitle("Sports");
        sdialog.show();
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest;
        stringRequest=new StringRequest(Request.Method.GET, Constants.Url_Sport, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    // Helpers.print(getActivity(),"Getting Data");
                    news.addAll(Connector.apiData(response));
                    // Helpers.print(getActivity(),"Data"+Connector.apiData(response));
                }

                catch (JSONException e) {
                    e.printStackTrace();
                }
                newsAdapter.notifyDataSetChanged();
                sdialog.dismiss();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Helpers.print(getActivity(),"SomeThing went wrong"+error.getMessage());

                sdialog.dismiss();

            }
        });
        stringRequest.setTag("tag");
        requestQueue.add(stringRequest);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(newsAdapter);

        return veiw;

    }
}


