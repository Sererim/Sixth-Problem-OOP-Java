package University_Java_6_OOP;

public class Person {
    
    private String firstName = "";
    private String secondName = "";
    private String sex = "";
    private String position = "";
    private String faculty = "";

    Person(String name, String surename, String sex, String position, String faculty)
    {
        this.firstName = name;
        this.secondName = surename;
        this.sex = sex;
        this.position = position;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        String foo = this.firstName + ";" + this.secondName + ";" +
        this.sex + ";" + this.position + ";" + this.faculty;
        return foo;
    }

}
