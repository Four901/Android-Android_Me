package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;


public class MasterListF extends Fragment {

    OnImageClickListener mcallback;
    public interface OnImageClickListener{
        void onImageSelected(int position);
    }
    public void onAttach(Context context) {

        super.onAttach(context);
        try
        {
         mcallback=(OnImageClickListener)context;

        }catch (ClassCastException e)
        {
            throw new ClassCastException("Not Not");
        }
    }
    public MasterListF() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView= inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView=(GridView) rootView.findViewById(R.id.images_grid_view);

        MasterListAdapter masterListAdapter=new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(masterListAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mcallback.onImageSelected(position);
            }
        });
        return rootView;
    }
}