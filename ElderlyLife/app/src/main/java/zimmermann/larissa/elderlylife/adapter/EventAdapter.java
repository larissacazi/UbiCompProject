package zimmermann.larissa.elderlylife.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.Util;
import zimmermann.larissa.elderlylife.R;
import zimmermann.larissa.elderlylife.Structure.Event;
import zimmermann.larissa.elderlylife.data.AppDataSingleton;
import zimmermann.larissa.elderlylife.utils.Utils;

/**
 * Created by laris on 27/11/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> events;
    private int rowLayout;
    private Context context;

    public static class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView eventName, eventDate, eventDescription;
        ImageView eventButton;
        boolean pressedButton;

        public EventViewHolder(View v) {
            super(v);

            eventName = (TextView) v.findViewById(R.id.eventNameTextID);
            eventDate = (TextView) v.findViewById(R.id.eventDateID);
            eventDescription = (TextView) v.findViewById(R.id.eventDescriptionID);
            eventButton = (ImageView) v.findViewById(R.id.eventButtonID);
            pressedButton = false;

            eventButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (AppDataSingleton.getInstace().getUserType() == Utils.APP_USER) {
                if (pressedButton == false) {
                    eventButton.setImageResource(R.drawable.ic_favorite_white_24dp);
                    Toast.makeText(v.getContext(), "Event added to Favorite", Toast.LENGTH_SHORT).show();
                } else if (pressedButton == true) {
                    eventButton.setImageResource(R.drawable.ic_favorite_border_white_24dp);
                    Toast.makeText(v.getContext(), "Event removed from Favorite", Toast.LENGTH_SHORT).show();
                }
                pressedButton = !pressedButton;
            } else if (AppDataSingleton.getInstace().getUserType() == Utils.OWNER_USER) {
                //TODO Open Event Edit Window
                Toast.makeText(v.getContext(), "Edit event clicked!", Toast.LENGTH_SHORT).show();
            }
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
    public void onBindViewHolder(final EventViewHolder holder, int position) {
        holder.eventName.setText(events.get(position).getName());
        String date = Utils.getDatePrintableFormat(events.get(position).getDate());
        holder.eventDate.setText(date);

        holder.eventDescription.setText(events.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        if(events == null) return 0;
        return events.size();
    }

    @Override
    public long getItemId(int position) {
        return events.get(position).getId();
    }

}
