package com.example_frag5.mamani.recycleview_tutorial;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by mamani on 21/07/16.
 */
public class CarFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<Car> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_car,container,false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener(){

                                              @Override
                                              public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                                                  super.onScrolled(recyclerView, dx, dy);

                                                  LinearLayoutManager lln = (LinearLayoutManager) mRecyclerView.getLayoutManager();

                                                  CarAdapter adapter=(CarAdapter) mRecyclerView.getAdapter();

                                                  if(mList.size()==lln.findLastCompletelyVisibleItemPosition()+1)
                                                  {
                                                      List<Car> listAux = ((MainActivity) getActivity()).getSetCarList(10);

                                                      for(int i=0;i<listAux.size();i++)
                                                      {
                                                          adapter.addListItem(listAux.get(i), mList.size());
                                                      }


                                                  }

                                              }

                                              @Override
                                              public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                                                  super.onScrollStateChanged(recyclerView, newState);

                                              }
                                          }

        );

        LinearLayoutManager lln = new LinearLayoutManager(getActivity());
        lln.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(lln);

        mList=((MainActivity) getActivity()).getSetCarList(10);
        CarAdapter adapter = new CarAdapter(getActivity(),mList);
        mRecyclerView.setAdapter(adapter);

        return view;
    }
}
