package com.example.proteintracker.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proteintracker.Model.Mahasiswa;
import com.example.proteintracker.R;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {
    private ArrayList<Mahasiswa> datalist;

    public MahasiswaAdapter(ArrayList<Mahasiswa>datalist){
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_mhs,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNamaMhs.setText(datalist.get(position).getNama());
        holder.txtNpmMhs.setText(datalist.get(position).getNpm());
        holder.txtNhpMhs.setText(datalist.get(position).getNohp());
    }

    @Override
    public int getItemCount() {
        return (datalist != null) ? datalist.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNamaMhs, txtNpmMhs, txtNhpMhs;
            public ViewHolder(@NonNull View itemView){
                super(itemView);
                txtNamaMhs = itemView.findViewById(R.id.txtNamaMhs);
                txtNhpMhs = itemView.findViewById(R.id.txtNhpMhs);
                txtNpmMhs = itemView.findViewById(R.id.txtNpmMhs);
            }
        }
}
