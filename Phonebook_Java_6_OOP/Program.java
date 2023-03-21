package Phonebook_Java_6_OOP;

public class Program {

    public static void main(String[] args) {
        Phonebook out = new Phonebook("db.txt", -1, ",");
        ExportPhoneBook expor = new ExportPhoneBook();
        if(expor.expor(out))
            System.out.println("GOOD");
        else
            System.out.println("BAD");   
        Phonebook in = new Phonebook("db1.txt", 100, ",");
        ImportPhoneBook im = new ImportPhoneBook();
        if(im.impor(in))
            System.out.println("GOOD");
        else
            System.out.println("BAD");   
    }
}
