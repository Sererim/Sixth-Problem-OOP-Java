package University_Java_5_OOP;

public class Program {
    
    public static void main(String[] args) {
        Person p = new Person("Hope", "Nichalson", "Female", "Professor", "Engineering");
        University uni = new University(p);
        System.out.println(uni);
        uni.save();
        uni.search("Professor");
    }
}
