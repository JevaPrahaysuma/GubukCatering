package com.example.jeva.gubugcatring;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jeva on 14/04/2018.
 */

public class RegisterAdapter extends RecyclerView.Adapter<RegisterAdapter.CustomViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<RegistrasiModel> registrasiModel;
    private Context context;
    private RegistrasiHelper registrasiHelper;

    public RegisterAdapter(Context context) {
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        registrasiHelper = new RegistrasiHelper(context);


    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                viewGroup.getContext());
        View v =
                inflater.inflate(R.layout.row_datauser, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;
    }




    @Override
    public void onBindViewHolder(final RegisterAdapter.CustomViewHolder holder, final int position) {
        final String email = registrasiModel.get(position).getEmail();
        final String username = registrasiModel.get(position).getUsername();
        final String password= registrasiModel.get(position).getPassword();
        holder.editEmail.setText(email);
        holder.editUsername.setText(username);
        holder.editPassword.setText(password);


        holder.btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registrasiModel.get(position).setEmail(holder.editEmail.getText().toString());
                registrasiModel.get(position).setUsername(holder.editUsername.getText().toString());
                registrasiModel.get(position).setPassword(holder.editPassword.getText().toString());

                registrasiHelper.open();
                registrasiHelper.update(registrasiModel.get(position));
                registrasiHelper.close();
                Toast.makeText(context, "updated", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });
        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteitem(registrasiModel.get(position).getId());
                registrasiModel.remove(position);
                notifyDataSetChanged();

            }
        });

    }
    private void deleteitem(int id) {

        registrasiHelper.open();
        registrasiHelper.delete(id);
        registrasiHelper.close();

        Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        return registrasiModel.size();
    }
    public void addItem(ArrayList<RegistrasiModel> mData) {
        this.registrasiModel = mData;
        notifyDataSetChanged();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private EditText editEmail;
        private EditText editUsername, editPassword;
        private Button btnupdate, btndelete;
        private CardView cv;

        public CustomViewHolder(View itemView) {
            super(itemView);

            this.editEmail = (EditText) itemView.findViewById(R.id.edit_email);
            this.editUsername = (EditText) itemView.findViewById(R.id.edit_username);
            this.editPassword = (EditText) itemView.findViewById(R.id.edit_password);
            btnupdate = (Button) itemView.findViewById(R.id.btn_update);
            btndelete = (Button) itemView.findViewById(R.id.btn_delete);
            cv = (CardView) itemView.findViewById(R.id.cv);


        }

    }
}
