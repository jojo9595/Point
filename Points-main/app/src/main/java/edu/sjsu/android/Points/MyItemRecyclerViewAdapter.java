package edu.sjsu.android.Points;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.sjsu.android.Points.placeholder.PlaceholderContent;

import edu.sjsu.android.Points.databinding.FragmentSceneryBinding;

import java.util.ArrayList;
import java.util.List;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<PlaceholderContent> mValues;

    public MyItemRecyclerViewAdapter(ArrayList<PlaceholderContent> items) {
        this.mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentSceneryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mName.setText(mValues.get(position).name);
        holder.tvDetail.setText(mValues.get(position).introduce);
        holder.tvAddress.setText(mValues.get(position).address);
        holder.mIvImg.setImageResource(mValues.get(position).img);
//        holder.mContentView.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mName;
        public final TextView tvAddress;
        public final TextView tvDetail;
        public final ImageView mIvImg;
        public PlaceholderContent mItem;

        public ViewHolder(FragmentSceneryBinding binding) {
            super(binding.getRoot());
            mIvImg = binding.ivImg;
            mName = binding.tvName;
            tvAddress = binding.tvAddress;
            tvDetail = binding.tvDetail;

        }


    }
}