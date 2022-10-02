package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
   ArrayList<MarketModel> marketModels=new ArrayList<>();
   int[] Images={R.drawable.store,R.drawable.fruits,
           R.drawable.vegetables,R.drawable.meat,
           R.drawable.fish,R.drawable.chicken,
           R.drawable.milk,R.drawable.cheese,
           R.drawable.nuts,R.drawable.coffee};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.myRv);
        setMarketModels();
        RecyclerViewAdapter adapter= new RecyclerViewAdapter(this,marketModels,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setMarketModels(){
    String[] Titles=getResources().getStringArray(R.array.Titles);
        String[] Description=getResources().getStringArray(R.array.description);
        for (int i=0; i<Titles.length;i++){
            marketModels.add(new MarketModel(Titles[i],Description[i],Images[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
      Intent intent = new Intent(MainActivity.this,MainActivity2.class);
      intent.putExtra("Title",marketModels.get(position).getTitle());
        intent.putExtra("Description",marketModels.get(position).getDescription());
        intent.putExtra("Image",marketModels.get(position).getImage());

        startActivity(intent);

    }
}