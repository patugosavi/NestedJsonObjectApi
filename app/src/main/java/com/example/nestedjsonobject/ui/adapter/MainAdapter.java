package com.example.nestedjsonobject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nestedjsonobject.R;
import com.example.nestedjsonobject.ui.model.DataModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    Context mContext;
    List<DataModel> dataModelList;

    public MainAdapter(Context mContext, List<DataModel> dataModelList) {
        this.mContext = mContext;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_datacard,parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainViewHolder holder, int position) {
        DataModel dataModel=dataModelList.get(position);

        holder.tv_firstname.setText(dataModel.getFirstName());
        holder.tv_lastname.setText(dataModel.getLastName());
        holder.tv_email.setText(dataModel.getEmail());

        Glide.with(mContext)
                .load(dataModel.getAvatar())
                .into(holder.iv_image);


    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public void getinfo(List<DataModel> dataModelList) {
        this.dataModelList=dataModelList;
        notifyDataSetChanged();
    }


    public class MainViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_firstname) TextView tv_firstname;
        @BindView(R.id.tv_lastname) TextView tv_lastname;
        @BindView(R.id.tv_email) TextView tv_email;
        @BindView(R.id.iv_image)
        ImageView iv_image;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
