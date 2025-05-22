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

public class EPLAdapter extends RecyclerView.Adapter<EPLAdapter.TeamViewHolder> {
    private List<EPLModel> teams;

    public EPLAdapter(List<EPLModel>teams){
        this.teams = teams;
    }

    @NonNull
    @Override
    public EPLAdapter.TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.epl_item_layout, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EPLAdapter.TeamViewHolder holder, int position) {
        EPLModel team = teams.get(position);
        holder.name.setText(team.getStrTeam());
        holder.stadium.setText(team.getStrStadium());
        holder.shortName.setText(team.getStrTeamShort());
        Glide.with(holder.badge.getContext()).load(team.getStrBadge()).into(holder.badge);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView stadium;
        TextView shortName;
        ImageView badge;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvNamaTeam);
            stadium = itemView.findViewById(R.id.tvNamaStadium);
            shortName = itemView.findViewById(R.id.tvNamaPendek);
            badge = itemView.findViewById(R.id.ivBadge);
        }
    }
}
