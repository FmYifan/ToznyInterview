package IMyif;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import static IMyif.Main.*;

/**
 * Parse the json file into list of items
 */
public class Parser {

    private Reader reader;

    public Parser(Reader reader) {
        this.reader = reader;
    }

    /**
     * Loading Data from the json file into the lists. itemList stores all items' data.
     * bookList stores all books' data. dvdList stores all dvds' data. cdList stores all cd's data.
     * These Lists are sorted in ascending order.
     */
    public void parse(){
        try{
            Gson gson = new Gson();
            itemList = gson.fromJson(reader, new TypeToken<ArrayList<Item>>() {}.getType());
            reader.close();
            Collections.sort(itemList);
            for (Item item : itemList) {
                switch (item.getType()) {
                    case "book" -> bookList.add(item);
                    case "dvd" -> dvdList.add(item);
                    case "cd" -> cdList.add(item);
                    default -> System.err.println("Loading error: Unknown type of item.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
