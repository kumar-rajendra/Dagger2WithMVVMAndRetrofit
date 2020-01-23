package com.example.mvvmrecyclerview;

import android.os.Bundle;

import com.example.mvvmrecyclerview.adapters.RecyclerAdapter;
import com.example.mvvmrecyclerview.adapters.RecyclerTopAdapter;
import com.example.mvvmrecyclerview.models.NicePlace;
import com.example.mvvmrecyclerview.repositories.NicePlaceRepository;
import com.example.mvvmrecyclerview.services.IRemoteService;
import com.example.mvvmrecyclerview.viewmodels.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.DaggerAppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends DaggerAppCompatActivity {

    MainActivityViewModel mainActivityViewModel;
    RecyclerView mRecyclerView,mRecyclerViewTop;
    RecyclerAdapter mRecylerAdapter;
    RecyclerTopAdapter mRecylerAdapterTop;

    @Inject
    String testStr;

    @Inject
    IRemoteService remoteService;

    @Inject
    NicePlaceRepository nicePlaceRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("TAG",remoteService.GetServerName());

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRecyclerView=findViewById(R.id.mRecycler);
        mRecyclerViewTop=findViewById(R.id.mRecyclerTop);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();
        mainActivityViewModel.getNicePlaces().observe(this ,new Observer<List<NicePlace>>()
            {
                @Override
                public void onChanged(List<NicePlace> nicePlace) {
                    mRecylerAdapter.notifyDataSetChanged();
                }
            }
        );


    initRecyclerView();
    }
    private void initRecyclerView()
    {
        mRecylerAdapter = new RecyclerAdapter(this, mainActivityViewModel.getNicePlaces().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mRecylerAdapter);

        mRecylerAdapterTop = new RecyclerTopAdapter(this, mainActivityViewModel.getNicePlaces().getValue());
        RecyclerView.LayoutManager linearLayoutManagerTop = new LinearLayoutManager(this);
        mRecyclerViewTop.setLayoutManager(linearLayoutManagerTop);
        mRecyclerViewTop.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false));
        mRecyclerViewTop.setAdapter(mRecylerAdapterTop);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
