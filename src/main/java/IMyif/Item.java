package IMyif;


import com.google.gson.Gson;

public class Item implements Comparable<Item>{

    //common fields for three types of items
    private float price;
    private String type;
    private int year;
    private String title;

    //book fields
    private String author;
    private String [] chapters;

    //dvd fields
    private int minutes;
    private String director;

    //cd fields
    class Track{
        private int seconds;
        private String name;

        public int getSeconds(){
            return seconds;
        }

        public String getName(){
            return name;
        }
    }
    public Track[] tracks;


    //Getter
    public float getPrice(){
        return price;
    }

    public String getType(){
        return type;
    }

    public int getYear(){
        return year;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String[] getChapters(){
        return chapters;
    }

    public int getMinutes(){
        return minutes;
    }

    public Track[] getTracks() {
        return tracks;
    }



    /**Implement the comparable interface. Sort the item by price.(Item with the smaller price is smaller)
     * @param item2 the item that compare with
     * @return the compare result. Positive means this item's price is higher. Otherwise, this item's price is lower.
     */
    @Override
    public int compareTo(Item item2) {
        return (int) (this.price - item2.price);
    }



    /**
     * @return the String format of the chapters
     */
    private String chaptersString(){
        if(chapters != null){
            StringBuilder sb = new StringBuilder();
            for(String chapter : chapters){
                sb.append(chapter + " ");
            }
            return sb.toString();
        }
        return null;
    }



    /**
     * @return the String format of the Tracks
     */
    private String tracksString(){
        if(tracks != null){
            StringBuilder sb = new StringBuilder();
            for(Track track : tracks){
                sb.append("Name: " + track.getName() + " " + "Seconds: " + track.getSeconds() + "\t");
            }
            return sb.toString();
        }
        return null;
    }



    /**
     * @return the String format of the item
     */
    @Override
    public String toString() {
        String result = null;
        try {
            switch (type) {
                case "book":
                    result = "Type: " + type + "\t" + "Title: " + title + "\t" + "Author: " + author + "\t"
                            + "Year: " + year + "\t" + "Chapters: { " + chaptersString() + "}\t" + "Price: " + price;
                    break;
                case "dvd":
                    result = "Type: " + type + "\t" + "Title: " + title + "\t" + "Director: " + director + "\t"
                            + "Year: " + year + "\t" + "Minutes: " + minutes + "\t" + "Price: " + price;
                    break;
                case "cd":
                    result = "Type: " + type + "\t" + "Title: " + title + "\t" + "Author: " + author + "\t"
                            + "Year: " + year + "\t" + "Tracks: { " + tracksString() + "}\t" + "Price: " + price;
                    break;
                default:
                    System.err.println("Unexpected value: " + type);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
