package de.codereddev.soundboardnofavorites;

import android.graphics.drawable.Drawable;

public class SoundObject {

    // SoundObject is an object that stores all kind of information you need for a sound button
    // like a name and the soundID/itemID
    // The itemID will be the resource id for a raw .mp3 file that is stored in the raw folder in the projects res folder
    private String itemName;
    private Integer itemID;
    private Integer item;

    public SoundObject(String itemName, Integer itemID, Integer item){

        this.itemName = itemName;
        this.itemID = itemID;
        this.item = item;
    }

    public String getItemName(){

        return itemName;
    }

    public Integer getItemID(){

        return itemID;
    }
    public Integer getItem(){

        return item;
    }
}
