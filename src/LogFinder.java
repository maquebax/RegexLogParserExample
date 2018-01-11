import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFinder {

    public static void main(String[] args) {


        try {

            List<String> queryList = fetchUpgradeActions();
            String patternString = "(upgradeToCurrent for " + "inventory" + "(.*?) [<]{1})" + "(.*?)" + "([>]{1})"; //[789]";
            Pattern pattern = Pattern.compile(patternString, Pattern.MULTILINE);
            System.out.println("regex pattern:" + pattern.pattern());
            FileReader fr = new FileReader("C:/Users/sridhvi/Desktop/ARGO-135331/trunk logs/navis-apex.log");
            Scanner scanner = new Scanner(fr);
            int i = 1;


            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                Matcher matcher = pattern.matcher(input);
                while (matcher.find()) {
                    System.out.println("************ line number " + i);
                    System.out.println("found the text " + matcher.group(3) + " starting at index " +
                            matcher.start() + " and ending at index " + matcher.end());
                }
                i++;
            }


        } catch (FileNotFoundException e) {
            System.out.println("**************" + e.getMessage());
        }
    }

    private static List<String> fetchUpgradeActions() {
        List<String> queryList = new ArrayList<String>();
        queryList.add("com.navis.inventory.upgrade.InventoryUpgradeAction310002");
        queryList.add("com.navis.inventory.upgrade.InventoryUpgradeAction310003");
        queryList.add("com.navis.inventory.upgrade.InventoryUpgradeAction310011");
        queryList.add("com.navis.inventory.upgrade.InventoryUpgradeAction310002");
        queryList.add("com.navis.inventory.upgrade.InventoryUpgradeAction310015");


        return queryList;
    }
}