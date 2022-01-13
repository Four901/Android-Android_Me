package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListF.OnImageClickListener {
    public int legIndex;
    public int headIndex;
    public int bodyIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onImageSelected(int position) {

      int rem=position-12*(position/12);
      if(rem==0)
      {
          headIndex=position;
      }
      else if(rem==1)
      {
      bodyIndex=position;
      }
      else
      {
          bodyIndex=position;
      }
      Bundle bundle=new Bundle();
        bundle.putInt("head",headIndex);
        bundle.putInt("body",bodyIndex);
        bundle.putInt("leg",legIndex);
        final Intent intent =new Intent(this,AndroidMeActivity.class);
        intent.putExtra("bundle",bundle);
        Button button=(Button) findViewById(R.id.next_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}
