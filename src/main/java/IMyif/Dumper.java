package IMyif;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Dump the items as json format
 */
public class Dumper {

    private Writer writer;

    public Dumper(Writer writer) {
        this.writer = writer;
    }

    /**
     * Dump one item using json format
     * @param item the item being dumped
     */
    public void dumpItem(Item item){
        try{
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(item, writer);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Dump a list of item using json format
     * @param itemList the list being dumped
     */
    public void dumpListItem(ArrayList<Item> itemList){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            for(Item item : itemList){
                gson.toJson(item, writer);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
