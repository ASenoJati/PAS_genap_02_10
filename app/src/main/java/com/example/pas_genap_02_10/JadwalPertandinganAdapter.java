package com.example.pas_genap_02_10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class JadwalPertandinganAdapter extends RecyclerView.Adapter<JadwalPertandinganAdapter.ViewHolder> {
    private List<JadwalPertandinganModel> jadwalList;

    public JadwalPertandinganAdapter(List<JadwalPertandinganModel> jadwalList) {
        this.jadwalList = jadwalList;
    }

    @NonNull
    @Override
    public JadwalPertandinganAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jadwal_pertandingan_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalPertandinganAdapter.ViewHolder holder, int position) {
        JadwalPertandinganModel jadwal = jadwalList.get(position);
        holder.tvJadwalPertandingan.setText(jadwal.getDateEventLocal() + " • " + jadwal.getStrTimeLocal());
        holder.tvHomeTeam.setText(jadwal.getStrHomeTeam());
        holder.tvAwayTeam.setText(jadwal.getStrAwayTeam());
        Glide.with(holder.itemView.getContext()).load(jadwal.getStrHomeTeamBadge()).into(holder.ivHomeTeam);
        Glide.with(holder.itemView.getContext()).load(jadwal.getStrAwayTeamBadge()).into(holder.ivAwayTeam);
    }

    @Override
    public int getItemCount() {
        return jadwalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJadwalPertandingan;
        TextView tvHomeTeam;
        TextView tvAwayTeam;
        ImageView ivHomeTeam;
        ImageView ivAwayTeam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJadwalPertandingan = itemView.findViewById(R.id.tvJadwalPertandingan);
            tvHomeTeam = itemView.findViewById(R.id.tvHomeTeam);
            tvAwayTeam = itemView.findViewById(R.id.tvAwayTeam);
            ivHomeTeam = itemView.findViewById(R.id.ivHomeTeam);
            ivAwayTeam = itemView.findViewById(R.id.ivAwayTeam);
        }
    }
}
