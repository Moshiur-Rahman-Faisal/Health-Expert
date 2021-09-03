package com.example.healthexpert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterBlood extends RecyclerView.Adapter<AdapterBlood.ViewHolder> {


    private List<ModelClassBlood> userlist;

    public AdapterBlood(List<ModelClassBlood>userlist){ this.userlist = userlist;}


    @NonNull
    @Override
    public AdapterBlood.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_blood, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBlood.ViewHolder holder, int position) {


        int bloodImage = userlist.get(position).getImageviewofblood();
        String nameBlood = userlist.get(position).getTextName();
        String groupBlood = userlist.get(position).getBloodgroup();
        String emailBlood = userlist.get(position).getBloodemail();


        holder.setData(bloodImage, nameBlood, groupBlood, emailBlood);

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        private ImageView mimageviewofblood;
        private TextView mtextname;
        private TextView mbloodgroup;
        private TextView mbloodemail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mimageviewofblood = itemView.findViewById(R.id.imageviewofblood);
            mtextname = itemView.findViewById(R.id.bloodName);
            mbloodgroup = itemView.findViewById(R.id.bloodgroup);
            mbloodemail = itemView.findViewById(R.id.bloodemail);




        }

        public void setData(int bloodImage, String nameBlood, String groupBlood, String emailBlood) {

            mimageviewofblood.setImageResource(bloodImage);
            mtextname.setText(nameBlood);
            mbloodgroup.setText(groupBlood);
            mbloodemail.setText(emailBlood);
        }
    }
}
