package ardiansyah.skripsi.com.banksampahrw09.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import ardiansyah.skripsi.com.banksampahrw09.R;
import ardiansyah.skripsi.com.banksampahrw09.model.ModelPengguna;


/**
 * Created by Ardiansyah on 17/09/2017.
 */

public class AdapterPengguna extends RecyclerView.Adapter<AdapterPengguna.AdapterHolder> {

    public Context mContext;
    public List<ModelPengguna.Pengguna> listPengguna;

    public AdapterPengguna (Context mContext, List<ModelPengguna.Pengguna> listPengguna){
        this.mContext = mContext;
        this.listPengguna = listPengguna;
    }

    @Override
    public AdapterPengguna.AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(mContext).inflate(R.layout.list_item_pengguna, parent, false);
        AdapterPengguna.AdapterHolder adapterHolder = new AdapterPengguna.AdapterHolder(rowView);
        return adapterHolder;
    }

    @Override
    public void onBindViewHolder(AdapterPengguna.AdapterHolder holder, int position) {
        holder.username.setText("Username : " + listPengguna.get(position).username);
        holder.nama.setText("Nama : " + listPengguna.get(position).nama);
        holder.rt.setText("RT : " + listPengguna.get(position).rt);

        if(position % 2 == 0 ){
            holder.relativeLayout.setBackgroundColor(Color.parseColor("#c8e8ff"));
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return listPengguna.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        TextView username, nama, rt;
        RelativeLayout relativeLayout;

        public AdapterHolder(View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.txtUsername);
            nama = itemView.findViewById(R.id.txtNama);
            rt = itemView.findViewById(R.id.txtRT);
            relativeLayout = itemView.findViewById(R.id.relativeList);
        }
    }
}
