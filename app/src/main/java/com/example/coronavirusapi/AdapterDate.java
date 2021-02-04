package com.example.coronavirusapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ModelApi.LatestDate.DateList;

public class AdapterDate extends RecyclerView.Adapter<AdapterDate.ViewHolder> {

    private Context context;
    private List<DateList> _list;
    private InterfaceContent interfaceContent;

    public AdapterDate(Context context, List<DateList> _list, InterfaceContent interfaceContent) {
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
        DateList list = _list.get(position);
        holder.textname.setText(list.getDate());
        holder.textNum.setText(String.valueOf(list.getTotalCases()));

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
                    interfaceContent.getDateInfo(_list.get(getAdapterPosition()));
                }
            });
        }
    }
}
