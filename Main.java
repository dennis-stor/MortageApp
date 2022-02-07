import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        List<String> names = new ArrayList<>();
        List <String> totalLoans = new ArrayList<>();
        List <String> totalYears = new ArrayList<>();
        List <String> monthlyPayments = new ArrayList<>();
        List <Prospect> prospects = new ArrayList<>();

        URL path = Main.class.getResource("prospects.txt");
        File f = new File(path.getFile());
        FileReader fr = new FileReader(f);
        BufferedReader bf = new BufferedReader(fr);

        String st = bf.readLine();
        String monthlyPayment;


        while((st = bf.readLine()) != null)
        {
            StringTokenizer stn = new StringTokenizer(st,",");

            String name = stn.nextToken();
            names.add(name);

            String totalLoan = stn.nextToken();
            totalLoans.add(totalLoan);

            String interest = stn.nextToken();

            String totalYear = stn.nextToken();
            totalYears.add(totalYear);

            monthlyPayment = Calculate.GetMonthlyPayment(Double.parseDouble(interest),
                    Double.parseDouble(totalLoan),Double.parseDouble(totalYear));
            monthlyPayments.add(monthlyPayment);

            Prospect prospect  = new Prospect(name,Double.parseDouble(totalLoan),
                    Double.parseDouble(interest),Integer.parseInt(totalYear),monthlyPayment);

            prospects.add(prospect);
        }

        bf.close();

        Borders.PrintBorder();

        for(int i = 0; i < prospects.size(); i++)
        {
            System.out.print("Prospect " + (i+1) + ": ");
            System.out.println(names.get(i) + " wants to borrow "
                    + totalLoans.get(i) + "€" + " for a period of "
                    + totalYears.get(i) + " years and pay "
                    + monthlyPayments.get(i) + "€ each month.");


            Borders.PrintBorder();
        }

    }

}
