/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {
    int headIndex;
    int bodyIndex;
    int legIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        Intent intent=getIntent();
        if(intent!=null)
        {
            Bundle bundle=intent.getBundleExtra("bundle");
            headIndex=bundle.getInt("head");
            bodyIndex=bundle.getInt("body");
            legIndex=bundle.getInt("leg");

        }
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            bodyPart headPart = new bodyPart();
            headPart.setImageIds(AndroidImageAssets.getHeads());
            headPart.setImageIndex(headIndex);

            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headPart)
                    .commit();

            bodyPart body_Part = new bodyPart();
            body_Part.setImageIds(AndroidImageAssets.getBodies());
            body_Part.setImageIndex(bodyIndex);
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, body_Part)
                    .commit();
            bodyPart legPart = new bodyPart();
            legPart.setImageIds(AndroidImageAssets.getLegs());
            legPart.setImageIndex(legIndex);
            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legPart)
                    .commit();
        }
    }

}
