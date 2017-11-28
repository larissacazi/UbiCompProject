package zimmermann.larissa.elderlylife.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import zimmermann.larissa.elderlylife.Structure.Event;

/**
 * Created by laris on 27/11/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> events;
    private int rowLayout;
    private Context context;

    public static class EventViewHolder extends RecyclerView.ViewHolder{

        LinearLayout propsLayout;
        TextView id, ano;
        TextView ementa;

        public EventViewHolder(View v) {
            super(v);

        }
    }

    public EventAdapter(List<Event> events, int rowLayout, Context context) {
        this.events = events;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        EventViewHolder holder = new EventViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final EventViewHolder holder, final int position) {

        /*holder.ementa.setText(context.getString(R.string.propListEmenta) + props.get(position).getEmenta());
        holder.id.setText(context.getString(R.string.propListCodigo) + String.valueOf(props.get(position).getId()));
        holder.ano.setText(context.getString(R.string.propListAno) + String.valueOf(props.get(position).getAno()));*/

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    @Override
    public long getItemId(int position) {
        return events.get(position).getId();
    }
}
