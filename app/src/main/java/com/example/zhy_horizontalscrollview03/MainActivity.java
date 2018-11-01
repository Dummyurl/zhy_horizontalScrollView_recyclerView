package com.example.zhy_horizontalscrollview03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.zhy_horizontalscrollview03.GalleryAdapter.OnItemClickListener;
import com.example.zhy_horizontalscrollview03.MyRecyclerView.OnItemScrollChangeListener;

public class MainActivity extends Activity {

    private MyRecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<Integer> mDatas;
    private ImageView mImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mImg = (ImageView) findViewById(R.id.id_content);

        mDatas = new ArrayList<Integer>(Arrays.asList(
                R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,
                R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8,
                R.drawable.a9, R.drawable.a10, R.drawable.a11, R.drawable.a12,
                R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16,
                R.drawable.a17, R.drawable.a18, R.drawable.a19, R.drawable.a20));

        mRecyclerView = (MyRecyclerView) findViewById(R.id.id_recyclerview_horizontal);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new GalleryAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setOnItemScrollChangeListener(new OnItemScrollChangeListener() {
            @Override
            public void onChange(View view, int position) {
                mImg.setImageResource(mDatas.get(position));
            }

            ;
        });

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//				Toast.makeText(getApplicationContext(), position + "", Toast.LENGTH_SHORT)
//						.show();
                mImg.setImageResource(mDatas.get(position));
            }
        });

    }

}
