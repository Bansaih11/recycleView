package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
     Context context;
    ArrayList<MarketModel>marketModels;

     public  RecyclerViewAdapter(Context context, ArrayList<MarketModel>marketModels,
     RecyclerViewInterface recyclerViewInterface){
      this.context=context;
      this.marketModels=marketModels;
      this.recyclerViewInterface=recyclerViewInterface;

     }


     @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // Where you inflate the layout(giving a look to our rows)
         LayoutInflater inflater=LayoutInflater.from(context);
         View view=inflater.inflate(R.layout.row_layout,parent,false);
        return new RecyclerViewAdapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public  void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     // assigning values to the view we createed in row_layout file
        // based on the position of recycler view
        holder.Title.setText(marketModels.get(position).getTitle());
        holder.description.setText(marketModels.get(position).getDescription());
        holder.imageView.setImageResource(marketModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
         // the RV just wants to know the number of items you want to display
        return marketModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
         // grabbing the views from our row_layout file
        // like in oncreate method
        ImageView imageView;
        TextView Title,description;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            Title=itemView.findViewById(R.id.txtTitle);
            description=itemView.findViewById(R.id.txtdescription);
            cardView=itemView.findViewById(R.id.cardView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface !=null);
                    int pos= getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        recyclerViewInterface.onItemClick(pos);
                    }
                }
            });

        }
    }

}
