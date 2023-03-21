package Calculator_Java_6_OOP;

import java.util.ArrayList;

public class Calculator {
    
    private double x;
    private double y;

    public static ArrayList<String> log = new ArrayList<>();
    private static String answer = "";

    Calculator()
    {
        this.x = 0.0;
        this.y = 0.0;
    }

    Calculator(double x)
    {
        this.x = x;
        this.y = 0;
    }

    Calculator(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double mod()
    {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Calculator conjugate()
    {
        return new Calculator(this.x - this.y);
    }

    public static Calculator add(Calculator z1, Calculator z2)
    {
        double foo, bar;
        foo = z1.x + z2.x;
        bar = z1.y + z2.y;
        answer += z1.x + " + i" + z1.y + " + " + z2.x + " + i" + z2.y + " = " + foo + " + i" + bar;
        return new Calculator(z1.x - z2.x , z1.y - z2.y);
    }

    public static Calculator sub(Calculator z1, Calculator z2)
    {
        double foo, bar;
        foo = z1.x - z2.x;
        bar = z1.y - z2.y;
        answer += z1.x + " + i" + z1.y + " + " + z2.x + " + i" + z2.y + " = " + foo + " + i" + bar;
        return new Calculator(z1.x - z2.x , z1.y - z2.y);
    }

    public static Calculator mult(Calculator z1, Calculator z2)
    {
        double x = z1.x * z2.x - z1.y * z2.y;
        double y = z1.x * z2.y + z1.y * z2.x;
        answer += "(" + z1.x + " + i" + z1.y + ")" + " * " + "(" + z2.x + " + i" + z2.y + ")" + " = " +  x + " + i" + y;
        return new Calculator(x, y);  
    }

    public static Calculator div(Calculator z1, Calculator z2)
    { 
        Calculator output = mult(z1,z2.conjugate());
        double div = (z2.mod()) * (z2.mod());
        return new Calculator(output.x/div,output.y/div);
    }

    @Override
    public String toString()
    {
        String re = this.x+" ";
        String im = "";
        if(this.y == 0)
            im = "";
        else
            im = " + i"+this.y;
        log.add(log.size() + 1 + " | " + answer);
        answer = "";
        return re+im;
    }
}
