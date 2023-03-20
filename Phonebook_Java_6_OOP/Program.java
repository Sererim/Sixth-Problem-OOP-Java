package Phonebook_Java_5_OOP;

public class Program {

    public static void main(String[] args) {
        Phonebook out = new Phonebook("db.txt", -1, ",");
        if(out.expor())
            System.out.println("GOOD");
        else
            System.out.println("BAD");   
        Phonebook in = new Phonebook("db1.txt", 100, ",");
        if(in.impor())
            System.out.println("GOOD");
        else
            System.out.println("BAD");   
    }
}
