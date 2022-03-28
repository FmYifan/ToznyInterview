package IMyif;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solutions {

    /**
     * Get N most expensive items in the sorted list
     * @param toSearch the list which is sorted in ascending order
     * @param num the number of the items returned (N)
     * @return an ArrayList that contains the N most expensive items
     */
    public ArrayList<Item> getMostExpensive(ArrayList<Item> toSearch, int num){
        ArrayList<Item> temp = new ArrayList<>();
        int firstIndex = toSearch.size() - num;
        if(firstIndex >= 0) {
            for (int i = firstIndex; i < toSearch.size(); i++) {
                temp.add(toSearch.get(i));
            }
        }
        else{
            temp.addAll(toSearch);
        }
        return temp;
    }


    /**
     * Get all cds that the total running time is longer than 60 minutes (3600 seconds) from the list
     * @param toSearch list that searched
     * @return a list that contains all cds meet the requirement
     */
    public ArrayList<Item> cdsLongerThan60Min(ArrayList<Item> toSearch){
        ArrayList<Item> temp = new ArrayList<>();
        for(Item item : toSearch){
            if(item.getType().equals("cd")){
                int sum = 0;
                for(Item.Track track : item.getTracks()){
                    sum += track.getSeconds();
                }

                //Test if the total running time is longer than 60 minutes
                if(sum > 3600){
                    temp.add(item);
                }
            }
        }

        return temp;
    }


    /**
     * Receive bookList and cdList as the arguments and check if there is any author released both book and cd
     * @param bookList the list contains books
     * @param cdList the list contains cds
     * @return an ArrayList that contains authors who have released both book and cd
     */
    public ArrayList<String> authorsReleaseBookAndCd(ArrayList<Item> bookList, ArrayList<Item> cdList){
        ArrayList<String> authors = new ArrayList<>();

        //Put authors of books in the hashset, iterate the cdList to find if authors occur twice.
        HashSet<String> set = new HashSet<>();
        for(Item item : bookList){
            set.add(item.getAuthor());
        }
        for(Item item : cdList){
            if(set.contains(item.getAuthor())){
                authors.add(item.getAuthor());
            }
        }
        return authors;
    }


    /**
     * Using Regular Expression to test if the string has a valid year (between 1000 - 2999)
     * @param toCheck the String needs to be checked
     * @return the boolean value. True means toCheck contains a year. Otherwise, return false.
     */
    private static boolean hasYear(String toCheck){
        toCheck = toCheck.replaceAll("\\D", "#");
        String[] array = toCheck.split("#");
        for(String check : array) {
            if (check.matches("^[1-2]\\d{3}$")) {
                return true;
            }
        }
        return false;
    }


    /**
     * Determine which items have a title, track or chapter that contains a year
     * @param itemList the list contains items need to be checked
     * @return an ArrayList contains items that their title, track or chapter contains a year
     */
    public ArrayList<Item> itemsAttributeContainYear(ArrayList<Item> itemList) {
        ArrayList<Item> result = new ArrayList<>();
        int flag = 0;
        for (Item item : itemList) {
            flag = 0;
            switch (item.getType()) {
                //Check if chapters contain year
                case "book":
                    for (String chapter : item.getChapters()) {
                        if (hasYear(chapter)) {
                            flag = 1;
                            break;
                        }
                    }
                    break;

                //Check if tracks contain year
                case "cd":
                    for (Item.Track track : item.getTracks()) {
                        if (hasYear(track.getName())) {
                            flag = 1;
                            break;
                        }
                    }
                    break;

                //Default Case
                default:
                    flag = 0;
            }

            //Check if title contains year
            if (hasYear(item.getTitle())) {
                flag = 1;
            }

            //If item contains year, then add it to the result list
            if (flag == 1) {
                result.add(item);
            }
        }

        return result;
    }


}
