package ysn.exampleswipeableitemrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.telecom.TelecomManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 21/02/17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<String> countries;

    public DataAdapter(List<String> countries) {
        this.countries = countries;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewCountry.setText(countries.get(position));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void addItem(String country) {
        countries.add(country);
        notifyItemInserted(countries.size());
    }

    public void removeItem(int position) {
        countries.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, countries.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCountry;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewCountry = (TextView) itemView.findViewById(R.id.text_view_country_row_layout);
        }
    }

}
