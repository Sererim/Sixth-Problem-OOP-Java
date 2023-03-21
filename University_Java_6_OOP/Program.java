package University_Java_6_OOP;

public class Program {
    
    public static void main(String[] args) {
        Person p = new Person("Hope", "Nichalson", "Female", "Professor", "Engineering");
        University uni = new University(p);
        SaveData.save(uni);
        System.out.println(uni);
        System.out.println(ReadData.read());
        Search.search("Professor", uni);
        System.out.println(uni.toString());
    }
}
