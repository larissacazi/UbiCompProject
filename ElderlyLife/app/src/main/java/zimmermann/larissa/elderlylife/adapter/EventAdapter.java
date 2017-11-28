package zimmermann.larissa.elderlylife.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import zimmermann.larissa.elderlylife.R;
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
        TextView eventName, eventDate, eventDescription;
        ImageView eventButton;
        boolean buttonPressed;

        public EventViewHolder(View v) {
            super(v);

            eventName = (TextView) v.findViewById(R.id.eventNameTextID);
            eventDate = (TextView) v.findViewById(R.id.eventDateID);
            eventDescription = (TextView) v.findViewById(R.id.eventDescriptionID);
            eventButton = (ImageView) v.findViewById(R.id.eventButtonID);
            buttonPressed = false;

            eventButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonPressed = !buttonPressed;

                    if(buttonPressed == true) eventButton.setImageResource(R.drawable.ic_favorite_black_24dp);
                    else if(buttonPressed == false) eventButton.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                }
            });
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
        holder.eventName.setText(events.get(position).getName());
        holder.eventDate.setText(events.get(position).getDate());
        holder.eventDescription.setText(events.get(position).getDescription());

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
