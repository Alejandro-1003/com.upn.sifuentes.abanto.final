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

import entidades.Carta;

public class CartasAdapter  extends RecyclerView.Adapter {
    List<Carta> cartasEncontradas;

    public CartasAdapter(List<Carta> cartasEncontradas){this.cartasEncontradas=cartasEncontradas;}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_carta,parent,false);
        return new CartasAdapter.CartasAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        final CartasAdapter.CartasAdapterViewHolder viewHolder = (CartasAdapterViewHolder) holder;
        TextView tvNombreCarta=holder.itemView.findViewById(R.id.tvNombreCarta);
        Button botVerCarta=holder.itemView.findViewById(R.id.botVerCartas);
        tvNombreCarta.setText(cartasEncontradas.get(position).name);
        botVerCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return cartasEncontradas.size();
    }

    static class CartasAdapterViewHolder extends RecyclerView.ViewHolder{

        public CartasAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
