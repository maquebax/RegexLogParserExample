import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args)
    {
        String input = "";
        try
        {
            FileReader fr = new FileReader("C:/Users/sridhvi/Desktop/ARGO-135331/test.log");
            Scanner scanner = new Scanner(fr);
            input = scanner.nextLine();

            Pattern pattern = Pattern.compile("\\[(.*?)\\] \\[error\\] \\[client (.*?)\\] (.*)", Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(input);

            while(scanner.hasNextLine())
            {
                input = scanner.nextLine();

                if(matcher.find())
                    System.out.println("IP: " + matcher.group(2));
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
