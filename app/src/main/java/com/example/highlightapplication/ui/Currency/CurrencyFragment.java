package com.example.highlightapplication.ui.Currency;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.highlightapplication.R;
import com.example.highlightapplication.databinding.FragmentCurrencyBinding;
import com.example.highlightapplication.ui.APIService.NetworkingService;
import com.example.highlightapplication.ui.StockPrice.StockData;
import com.example.highlightapplication.ui.StockPrice.StockPriceAdapter;

import java.util.ArrayList;


public class CurrencyFragment extends Fragment implements SearchView.OnQueryTextListener, NetworkingService.NetworkingListener {
    
    RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    String TAG="StockpriceFragment";
    NetworkingService networkingService;
    StockPriceAdapter adapter;
    ProgressDialog progressDialog;
    RecyclerView recyclerview;
    SearchView search_view;
    ArrayList<CurrencyData> currencyDataArrayList=new ArrayList<>();
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency, container, false);


        search_view = view.findViewById(R.id.currency_searchview);
        recyclerview = view.findViewById(R.id.recyclerview);

        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Fetching Currency Price Data");
        mRequestQueue= Volley.newRequestQueue(getActivity());
        sendAndRequestResponse();


        search_view.setOnQueryTextListener(this);
        search_view.setQueryHint("Search Currency to convertInto Canadian dollar");
        setHasOptionsMenu(true);

        return view;
    }

    private void sendAndRequestResponse() {
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("query change", query);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        Log.d("query change", newText);
        if (newText.length() >= 3) {
            // seach for city
            // networkingService.fetchCitiesData(newText);
        }
        else {
           /* adapter.cityList = new ArrayList<>(0);
            adapter.notifyDataSetChanged();*/
        }
        return false;
    }

    @Override
    public void APINetworkListner(String jsonString) {
        Log.d(TAG,"Json string="+jsonString);
    }

    @Override
    public void WorlTimeNetworkListner(String jsonString, int position) {

    }
}