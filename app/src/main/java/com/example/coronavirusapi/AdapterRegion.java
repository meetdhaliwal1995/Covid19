package com.example.coronavirusapi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ModelApi.LatestModel.example.RegionInfo;

public class AdapterRegion extends RecyclerView.Adapter<AdapterRegion.ViewHolder> {

    private Context context;
    private List<RegionInfo> _list;
    private InterfaceContent interfaceContent;

    public AdapterRegion(Context context, List<RegionInfo> _list, InterfaceContent interfaceContent) {
        this.context = context;
        this._list = _list;
        this.interfaceContent = interfaceContent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RegionInfo list = _list.get(position);
        holder.textname.setText(String.valueOf(list.getName()));
        holder.textNum.setText(String.valueOf(list.getActiveCases()));
    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textname, textNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textname = itemView.findViewById(R.id.name_ada);
            textNum = itemView.findViewById(R.id.num_ada);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("ddd", "fff");
                    if (interfaceContent != null) {
                        interfaceContent.getRegionInfo(_list.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
