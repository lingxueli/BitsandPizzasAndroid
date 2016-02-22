package com.hfad.bitsandpizzas;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class TopFragment extends Fragment {

    public TopFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_top, container, false);
        RecyclerView pizzaRecycler = (RecyclerView) layout.findViewById(R.id.pizza_recycler);

        String[] pizzaNames = new String[2];
        for(int i = 0; i < 2; i++){
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }

        int[] pizzaImages = new int[2];
        for(int i = 0; i < 2; i++){
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }

        // Define the layout manager
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        pizzaRecycler.setLayoutManager(layoutManager);

        // Assign the adapter to recycle view
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames,pizzaImages);
        pizzaRecycler.setAdapter(adapter);

        // Set listener for recycle view
        adapter.setListener(new CaptionedImagesAdapter.Listener(){
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(),PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZANO,position);
                getActivity().startActivity(intent);
            }
        });
        return layout;
    }

}
