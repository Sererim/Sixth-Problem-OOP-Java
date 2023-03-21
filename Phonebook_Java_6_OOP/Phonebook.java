package Phonebook_Java_6_OOP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Phonebook
 * ID,Surename,Name,Patronym,Phone,
 * 1,Ivanov,Ivan,Ivanovich,+7(900)-000-00-00, 
 */

public class Phonebook {

    public static String filename = "Phonebook_Java_6_OOP\\book.csv";

    public String namefile = "";
    public int what = 0;
    public String parator = "";
    
    /*
     * @ param name of the file
     * @ param what to do with the file read from or export to
     * to export integer must be <0, to import to >0
     */
    Phonebook(String file, int what, String sep)
    {
        this.namefile ="Phonebook_Java_6_OOP\\" + file;
        this.what = what;
        this.parator = sep;
    }
}

class ExportPhoneBook
{
    public boolean expor(Phonebook p)
    {
        if(p.what < 0)
        {
            // reading data from book.csv
            String foo = "";
            try{
                foo = new String(Files.readAllBytes(Paths.get(Phonebook.filename)));
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            ArrayList<String> bar = new ArrayList<String>();
            foo = foo.replace("\n", "").replace("\r", "").replace("\r\n", "").replaceAll("\n\r", "");
            bar = new ArrayList<String>(Arrays.asList(foo.split(";")));
            for (String string : bar) {
                System.out.println(string);
            }
            // storing data from book.csv into a new file
            try (FileWriter fw = new FileWriter(p.namefile, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
            {
                for(int i = 0; i < bar.size(); i++)
                {
                    if(i % 5 == 0 && i != 0)
                        out.println();
                    out.print(bar.get(i) + p.parator);
                }
            }
            catch (Exception e) {
                System.out.println("ERROR ON WRITING TO FILE!");
            }
        }
        else
            return false;
        return true;
    }
}

class ImportPhoneBook
{
    public boolean impor(Phonebook p)
    {
        if(p.what > 0)
        {
            // reading data from new file
            String foo = "";
            try{
                foo = new String(Files.readAllBytes(Paths.get(p.namefile)));
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            ArrayList<String> bar = new ArrayList<String>();
            foo = foo.replace("\n", "").replace("\r", "").replace("\r\n", "").replaceAll("\n\r", "");
            bar = new ArrayList<String>(Arrays.asList(foo.split(p.parator)));

            // storing new data in book.csv
            try (FileWriter fw = new FileWriter(Phonebook.filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
            {
                for(int i = 0; i < bar.size(); i++)
                {
                    if(i % 5 == 0 && i != 0)
                        out.println();
                    out.print(bar.get(i) + ";");
                }
            }
            catch (Exception e) {
                System.out.println("ERROR ON WRITING TO FILE!");
            }
        }
        else
            return false;
        return true;
    }
}
