package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jasa.comupnsifuentesabantofinal.R;

import java.util.List;

import entidades.Duelista;

public class DuelistasAdapter extends RecyclerView.Adapter{
    List<Duelista> allDuelistas;

    public DuelistasAdapter(List<Duelista> allDuelistas){this.allDuelistas=allDuelistas;}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_duelista,parent,false);
        return new DuelistasAdapter.DuelistasAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final DuelistasAdapter.DuelistasAdapterViewHolder viewHolder=(DuelistasAdapterViewHolder) holder;
        TextView tvDuelistaId=holder.itemView.findViewById(R.id.itemDuelistaId);
        TextView tvDuelistaNombre=holder.itemView.findViewById(R.id.itemDuelistaNombre);
        Button itemDuelistaBoton=holder.itemView.findViewById(R.id.itemDuelistaBoton);
        tvDuelistaId.setText(""+allDuelistas.get(position).id);
        tvDuelistaNombre.setText(allDuelistas.get(position).name);
        itemDuelistaBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return allDuelistas.size();
    }

    static class DuelistasAdapterViewHolder extends RecyclerView.ViewHolder{

        public DuelistasAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
