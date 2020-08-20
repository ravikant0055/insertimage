package Adapters;

import android.content.Context;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.previewss.R;

import java.util.ArrayList;

import Models.Model_recycler;

public class Adapter_recyclerview extends RecyclerView.Adapter<Adapter_recyclerview.viewholder> {

    ArrayList<Model_recycler> list;
    Context context;

    public Adapter_recyclerview(ArrayList<Model_recycler> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_recyclerview, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewholder holder, int position) {
      Model_recycler model = list.get(position);
      holder.img.setImageResource(model.getPic());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Image clicked",Toast.LENGTH_LONG).show();
            }
        });
        holder.img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context,"Long Image clicked",Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView img;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageviews);
        }
    }
}
