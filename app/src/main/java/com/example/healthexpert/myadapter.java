package com.example.healthexpert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class myadapter extends FirebaseRecyclerAdapter<ModelClass, myadapter.myviewholder> {

    public myadapter(@NonNull FirebaseRecyclerOptions<ModelClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder myviewholder, int i, @NonNull ModelClass modelClass) {


        myviewholder.username.setText(modelClass.getUsername());
        myviewholder.bloodgroup.setText(modelClass.getBlood());
        myviewholder.email.setText(modelClass.getEmail());

        Picasso.get().load(modelClass.img).into(myviewholder.imageblood);




    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowblood, parent, false);
        return new myviewholder(view);

    }

    class myviewholder extends RecyclerView.ViewHolder{

        ImageView imageblood;
        TextView username, bloodgroup, email;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            imageblood = (ImageView)itemView.findViewById(R.id.imageviewofblood);
            username = (TextView) itemView.findViewById(R.id.bloodName);
            bloodgroup = (TextView) itemView.findViewById(R.id.bloodgroup);
            email = (TextView) itemView.findViewById(R.id.bloodemail);

        }
    }


}
