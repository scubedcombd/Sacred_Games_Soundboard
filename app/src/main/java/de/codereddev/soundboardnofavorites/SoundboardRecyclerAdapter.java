package de.codereddev.soundboardnofavorites;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SoundboardRecyclerAdapter extends RecyclerView.Adapter<SoundboardRecyclerAdapter.SoundboardViewHolder>{

    // Declare an ArrayList that will contain all SoundObjects
    private ArrayList<SoundObject> soundObjects;

    // Demand all needed informations for the RecyclerView
    // ArrayList<SoundObject> : Main content provider
    public SoundboardRecyclerAdapter(ArrayList<SoundObject> soundObjects){

        // Hand over all data to the private ArrayList
        this.soundObjects = soundObjects;
    }

    private int i=0;

    // Initialises each RecyclerView item
    @Override
    public SoundboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item, null);
                i++;
                return new SoundboardViewHolder(itemView);


//        switch(i) {
//            case 0 :
//                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item, null);
//                i++;
//                return new SoundboardViewHolder(itemView);
//
//
//            case 1 :
//                View itemView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item2, null);
//                i++;
//                return new SoundboardViewHolder(itemView2);
//
//            case 2 :
//                View itemView3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item3, null);
//                i++;
//                return new SoundboardViewHolder(itemView3);
//
//            case 3 :
//                View itemView4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item4, null);
//                i++;
//                return new SoundboardViewHolder(itemView4);
//
//            case 4 :
//                View itemView5 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item5, null);
//                i++;
//                return new SoundboardViewHolder(itemView5);
//
//
//            case 5 :
//                View itemView6 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item6, null);
//                i++;
//                return new SoundboardViewHolder(itemView6);
//
//            case 6 :
//                View itemView7 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item7, null);
//                i++;
//                return new SoundboardViewHolder(itemView7);
//
//            case 7 :
//                View itemView8 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item8, null);
//                i++;
//                return new SoundboardViewHolder(itemView8);
//
//            case 8 :
//                View itemView9 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item9, null);
//                i++;
//                return new SoundboardViewHolder(itemView9);
//
//            case 9 :
//                View itemView10 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item10, null);
//                i++;
//                return new SoundboardViewHolder(itemView10);
//
//
//            case 10 :
//                View itemView11 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item11, null);
//                i++;
//                return new SoundboardViewHolder(itemView11);
//
//            case 11 :
//                View itemView12 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item12, null);
//                i++;
//                return new SoundboardViewHolder(itemView12);
//
//            case 12 :
//                View itemView13 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item13, null);
//                i++;
//                return new SoundboardViewHolder(itemView13);
//
//            case 13 :
//                View itemView14 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item14, null);
//                i++;
//                return new SoundboardViewHolder(itemView14);
//
//            case 14 :
//                View itemView15 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item15, null);
//                i++;
//                return new SoundboardViewHolder(itemView15);
//
//            case 15 :
//                View itemView16 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item16, null);
//                i++;
//                return new SoundboardViewHolder(itemView16);
//
//            case 16 :
//                View itemView17 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item17, null);
//                i++;
//                return new SoundboardViewHolder(itemView17);
//
//
//            // You can have any number of case statements.
//            default : // Optional
//                View itemView_default = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item11, null);
//                i=0;
//                return new SoundboardViewHolder(itemView_default);
//
//            }



        // Set the default design for a element in the RecyclerView that is based on sound_item.xml

    }

    @Override
    public void onBindViewHolder(SoundboardViewHolder holder, int position) {

        // Get a SoundObject from the ArrayList that also contains
        // Simplifies the set processes
        final SoundObject object = soundObjects.get(position);

        // Define an id for a simplified committing process
        final Integer soundID = object.getItemID();

        //final Dr thumbnailID = SoundboardActivity.getApplicationContext().getResources().getDrawable(object.getItem());

        // Set the name of each sound button that is represented by the (SoundObject)object
        holder.itemTextView.setText(object.getItemName());


       // holder.j.setImageResource(object.getItem());

        // Handle actions when the user simply clicks on a sound button
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Calls a method that plays the sound
                EventHandlerClass.startMediaPlayer(v, soundID);
            }
        });

        // Handle actions when the user presses a sound button
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                // Calls a method that creates a PopupMenu where the user can choose between several actions
                EventHandlerClass.popupManager(v, object);
                return true;
            }
        });
    }

    // Tells the RecyclerView how many items are accessible to be displayed
    // Should return the size of the given content provider (here: SoundObject ArrayList)
    @Override
    public int getItemCount() {
        return soundObjects.size();
    }

    // Gets all accessible areas that are declared by you
    public class SoundboardViewHolder extends RecyclerView.ViewHolder{

        // TextView to display the name of a sound button
        TextView itemTextView;

        public SoundboardViewHolder(View itemView) {
            super(itemView);

            // Assign itemTextView to the TextView item declared in sound_item.xml
            itemTextView = (TextView) itemView.findViewById(R.id.textViewItem);
        }
    }
}
