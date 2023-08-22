package com.example.shamels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shamels.databinding.ItemBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList<Dataclass> arrayList;
    Context context;


    public Adapter(ArrayList<Dataclass> arrayList,Context context) {
        this.arrayList = arrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext())
                , parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos = position;
        Dataclass s = arrayList.get(position);
        holder.Age.setText(s.getAge());
//        holder.namber.setText(String.valueOf(s.getHours()));
        holder.name.setText(s.getName());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView Age;

        public ViewHolder(@NonNull ItemBinding itemView) {
            super(itemView.getRoot());
            name = itemView.Name;
            Age = itemView.age;

        }
    }
}
