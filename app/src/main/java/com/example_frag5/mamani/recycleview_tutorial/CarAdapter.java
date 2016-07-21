package com.example_frag5.mamani.recycleview_tutorial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mamani on 21/07/16.
 */
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder>{

    private List<Car> mlist;
    private LayoutInflater mLayoutInflater;

    public CarAdapter(Context cnt, List<Car> mlist) {
        this.mlist = mlist;
        mLayoutInflater = (LayoutInflater) cnt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivcar;
        public TextView tvModel;
        public TextView tvBrand;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivcar = (ImageView) itemView.findViewById(R.id.iv_car);
            tvModel = (TextView) itemView.findViewById(R.id.tv_model);
            tvBrand = (TextView) itemView.findViewById(R.id.tv_brand);
        }
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //chamado quando se cria uma nova view
        View v = mLayoutInflater.inflate(R.layout.item_car,parent,false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //vincula o dado da lista a view
        holder.ivcar.setImageResource(mlist.get(position).getPhoto());
        holder.tvModel.setText(mlist.get(position).getModel());
        holder.tvBrand.setText(mlist.get(position).getBrand());
    }

    public void addListItem(Car c,int position)
    {
        mlist.add(c);
        notifyItemInserted(position);

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


}
