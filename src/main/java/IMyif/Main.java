package IMyif;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    //The lists of items
    public static ArrayList<Item> itemList = new ArrayList<>();
    public static ArrayList<Item> bookList = new ArrayList<>();
    public static ArrayList<Item> dvdList = new ArrayList<>();
    public static ArrayList<Item> cdList = new ArrayList<>();

    public static void main(String[] args){
        //Loading data (json file) into lists
        InputStream data = Main.class.getResourceAsStream("data.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(data));
        Parser parser = new Parser(reader);
        parser.parse();

        //Dump the items as the json format to the System.out
        //Dumper dumper = new Dumper(new OutputStreamWriter(System.out));

        Solutions solutions = new Solutions();

        //The first question: What are the 5 most expensive items from each category?
        ArrayList<Item> expensiveBooks = solutions.getMostExpensive(bookList, 5);
        ArrayList<Item> expensiveDvds = solutions.getMostExpensive(dvdList, 5);
        ArrayList<Item> expensiveCds = solutions.getMostExpensive(cdList, 5);
        for (Item item : expensiveBooks) {
            System.out.println(item);
        }
        //dumper.dumpListItem(expensiveBooks);

        for (Item item : expensiveDvds) {
            System.out.println(item);
        }
        //dumper.dumpListItem(expensiveDvds);

        for (Item item : expensiveCds) {
            System.out.println(item);
        }
        //dumper.dumpListItem(expensiveCds));

        System.out.println("----------");



        //The second question: Which cds have a total running time longer than 60 minutes?
        ArrayList<Item> longerThan60MinCds = solutions.cdsLongerThan60Min(cdList);
        for (Item item : longerThan60MinCds) {
            System.out.println(item);
        }
        //dumper.dumpListItem(longerThan60MinCds);
        System.out.println("----------");



        //The third question: Which authors have also released cds?
        ArrayList<String> authorsBookAndCd = solutions.authorsReleaseBookAndCd(bookList, cdList);
        for (String author : authorsBookAndCd) {
            System.out.println(author);
        }
        //dumper.dumpListItem(authorsBookAndCd);
        System.out.println("----------");



        //The fourth question: Which items have a title, track, or chapter that contains a year?
        ArrayList<Item> itemsContainYear = solutions.itemsAttributeContainYear(itemList);
        for (Item item : itemsContainYear) {
            System.out.println(item);
        }
        //dumper.dumpListItem(itemsContainYear);
        System.exit(0);

    }

}
