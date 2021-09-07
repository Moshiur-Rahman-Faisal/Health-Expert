package com.example.healthexpert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterDoctor extends RecyclerView.Adapter<AdapterDoctor.ViewHolder> {


    private List<ModelClassDoctor> userList;

    public AdapterDoctor(List<ModelClassDoctor> userList) {
        this.userList=userList;
    }


    @NonNull
    @Override
    public AdapterDoctor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdoctor,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDoctor.ViewHolder holder, int position) {

        int docImage = userList.get(position).getImageview();
        String docname=userList.get(position).getName();
        String docqualification=userList.get(position).getQualification();
        String doctime1=userList.get(position).getTimes1();
        String doctime2=userList.get(position).getTimes2();
        String doctime3=userList.get(position).getTimes3();


        holder.setData(docImage, docname, docqualification, doctime1, doctime2, doctime3);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


         private ImageView mImageView;
        private TextView mName;
        private TextView mQualification;
        private TextView mTime1;
        private TextView mTime2;
        private TextView mTime3;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView=itemView.findViewById(R.id.imageviewofdoc);
            mName=itemView.findViewById(R.id.doctorname);
            mQualification=itemView.findViewById(R.id.designation);
            mTime1=itemView.findViewById(R.id.time1);
            mTime2=itemView.findViewById(R.id.time2);
            mTime3=itemView.findViewById(R.id.time3);
        }


        public void setData(int docImage, String docname, String docqualification, String doctime1, String doctime2, String doctime3) {

            mImageView.setImageResource(docImage);
            mName.setText(docname);
            mQualification.setText(docqualification);
            mTime1.setText(doctime1);
            mTime2.setText(doctime2);
            mTime3.setText(doctime3);

        }
    }
}
