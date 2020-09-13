package Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
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

import java.io.IOException;
import java.util.ArrayList;

import Models.Model_recycler;

import static android.content.ContentValues.TAG;

public class Adapter_recyclerview extends RecyclerView.Adapter<Adapter_recyclerview.viewholder> {

    ArrayList<String> list;
    Context context;

    public Adapter_recyclerview(ArrayList<String> list, Context context) {
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
        String model = list.get(position);

//        convert string to uri
        Uri uri= Uri.parse(model);
        Log.d(TAG, "onBindViewHolder:11 "+uri.toString());

        try {
            Bitmap bitmapv = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
            holder.img.setImageBitmap(bitmapv);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
