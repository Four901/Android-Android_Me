package com.example.android.android_me.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link// bodyPart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bodyPart extends Fragment {

    private int imageIndex;
   private List<Integer>imageIds;
   public String IMAGE_INDEX="IMAGE_INDEX";
   public String LIST_IMAGE_IDS="LIST_IMAGE_IDS";
    public bodyPart() {
        // Required empty public constructor
    }

    public void setImageIndex(int index)
    {
        imageIndex=index;
    }
    public void setImageIds(List<Integer>ids)
    {
        imageIds=ids;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState!=null)
        {
            imageIds=savedInstanceState.getIntegerArrayList(LIST_IMAGE_IDS);
            imageIndex=savedInstanceState.getInt(IMAGE_INDEX);
        }
       View rootView=inflater.inflate(R.layout.fragment_body_part, container, false);
       ImageView imageView=(ImageView) rootView.findViewById(R.id.body_part_image_view);
       if(imageIds!=null)
       {
           imageView.setImageResource(imageIds.get(imageIndex));
       }

       return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle currentState) {
        currentState.putInt(IMAGE_INDEX,imageIndex);
        currentState.putIntegerArrayList(LIST_IMAGE_IDS, (ArrayList<Integer>)imageIds);

    }
}