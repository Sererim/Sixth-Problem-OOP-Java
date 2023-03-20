package University_Java_5_OOP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;


public class University {
    
    private static String filename = "University_Java_5_OOP\\database.csv";
    private static int mod = 6;

    private ArrayList<String> db = new ArrayList<>();
    private Person p;
    private int id;

    University(Person p)
    {
        this.p = p;
        read();
        getID();
    }

    University()
    {
        read();
    }

    @Override
    public String toString() {
        read();
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

    public void save()
    {
        // saving new entry to university database.
        String foo =this.id + ";" + this.p.getMe() + ";";
        try (FileWriter fw = new FileWriter(filename, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            out.println(foo);
        }
        catch (Exception e) {
            System.out.println("ERROR ON WRITING TO FILE!");
        }
    }

    private void read()
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
        db.addAll(bar);
    }

    private void getID() {
        if(db.size() % 6 == 0)
            this.id = (db.size() / 6);
    }

    public void search (String searchString)
    {
        System.out.println("-------------------------");
        int left = 0, right = 0;
        for(int i = 0; i < this.db.size(); i++)
        {
            if(searchString.equals(this.db.get(i)))
            {
                for(int k = i; k > 0; k--)
                    if(k % 6 == 0)
                    {
                        left = k;
                        break;
                    }
                for(int j = i; j < this.db.size(); j++)
                    if(j % 6 == 0)
                    {
                        right = j;
                        break;
                    }
                
                for(int j = left; j < right; j++)
                    System.out.print(this.db.get(j) + " ");
                    System.out.println();
            }
        }
        System.out.println("-------------------------");
    }
}
