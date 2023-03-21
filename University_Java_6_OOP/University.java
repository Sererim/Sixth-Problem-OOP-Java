package University_Java_6_OOP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;


public class University {
    
    private static int mod = 6;
    
    public ArrayList<String> db = new ArrayList<>();
    private Person p;

    University(Person p){
        this.p = p;
        db.addAll(ReadData.read());
    }

    University(){
        db.addAll(ReadData.read());
    }

    public String getMe(){
        return this.p.toString();
    }

    @Override
    public String toString() {
        db.addAll(ReadData.read());
        String foo = "";
        if(!db.isEmpty())
        {
            for(int i = 0; i < db.size(); i++)
            {
                if(i % mod == 0)
                    foo += "\n";
                foo += db.get(i) + "  ";
            }
        }
        return foo;
    }
}

class SaveData
{
    private static String filename = "University_Java_6_OOP\\database.csv";

    public static void save(University u)
    {
        // saving new entry to university database.
        String foo = GetID.getID(GetDB.getDB(u))+ ";" + u.getMe() + ";";
        try (FileWriter fw = new FileWriter(filename, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            out.print(foo);
            out.println();
        }
        catch (Exception e) {
            System.out.println("ERROR ON WRITING TO FILE!");
        }
    }
}

class ReadData
{
    private static String filename = "University_Java_6_OOP\\database.csv";
    public static ArrayList<String> read()
    {
        String foo = "";
        try{
            foo = new String(Files.readAllBytes(Paths.get(filename)));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        ArrayList<String> bar = new ArrayList<String>();
        foo = foo.replace("\n", "").replace("\r", "").replace("\r\n", "").replaceAll("\n\r", "");
        bar = new ArrayList<String>(Arrays.asList(foo.split(";")));
        return bar;
    }
}

class GetID
{
    public static int getID(ArrayList<String> db) {
        int foo = 0;
        foo = (db.size() / 6);
        return foo;
    }
}

class Search
{
    public static void search (String searchString, University u)
    {
        ArrayList<String> bar = GetDB.getDB(u);
        System.out.println("-------------------------");
        int left = 0, right = 0;
        for(int i = 0; i < bar.size(); i++)
        {
            if(searchString.compareTo(bar.get(i)) == 0)
            {
                for(int k = i; k > 0; k--)
                    if(k % 6 == 0)
                    {
                        left = k;
                        break;
                    }
                for(int j = i; j < bar.size(); j++)
                    if(j % 6 == 0)
                    {
                        right = j;
                        break;
                    }
                
                for(int m = left; m < right; m++)
                    System.out.print(bar.get(m) + " ");
                    System.out.println();
            }
        }
        System.out.println("-------------------------");
    }
}

class GetDB
{
    public static ArrayList<String> getDB(University u){
        return u.db;
    }
}