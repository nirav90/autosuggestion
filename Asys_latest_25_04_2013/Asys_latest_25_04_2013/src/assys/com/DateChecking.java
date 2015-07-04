package assys.com;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DateChecking {

    private static List<String> someList = new ArrayList<String>();

    public static void main(String[] args) {
        someList.add("monkey");
        someList.add("donkey");

        // Code works when I change Iterator to java.util.Iterator, but import
        // is not possible?
        for (Iterator<String> i = someList.iterator(); i.hasNext();) {
            String item = i.next();
            System.out.println(item);
        }
    }
}