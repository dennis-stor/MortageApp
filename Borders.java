public class Borders
{

    public static void PrintBorder()
    {
        String character = "*";
        String output = character;
        for(int i=0;i<30;i++)
        {
           output = output + character;
        }
        System.out.println(output);
    }

}
