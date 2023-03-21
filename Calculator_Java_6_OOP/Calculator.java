package Calculator_Java_6_OOP;

import java.util.ArrayList;

public class Calculator {

    private static ArrayList<String> log = new ArrayList<>();

    double x;
    double y;

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

    @Override
    public String toString()
    {
        String re = this.x+" ";
        String im = "";
        if(this.y == 0)
            im = "";
        else
            im = " + i"+this.y;
        log = Log.getLog();
        log.add(log.size() + " | " + log.get(log.size() - 1));
        return re+im;
    }
}

class Log
{
    private static ArrayList<String> log = new ArrayList<>();
    
    public static void addToLog(String answer){
        log.add(answer);
    }

    public static ArrayList<String> getLog(){
        return log;
    }
}

class Add
{
    public Calculator add(Calculator z1, Calculator z2)
    {
        double foo, bar;
        foo = z1.x + z2.x;
        bar = z1.y + z2.y;
        Log.addToLog(z1.x + " + i" + z1.y + " + " + z2.x + " + i" + z2.y + " = " + foo + " + i" + bar);
        return new Calculator(z1.x - z2.x , z1.y - z2.y);
    }
}

class Mod
{
    public double mod(Calculator z1)
    {
        return Math.sqrt(z1.x * z1.x + z1.y * z1.y);
    }
}

class Conjugate
{
    public Calculator conjugate(Calculator z1){
        return new Calculator(z1.x - z1.y);
    }
}

class Substract
{
    public Calculator sub(Calculator z1, Calculator z2)
    {
        double foo, bar;
        foo = z1.x - z2.x;
        bar = z1.y - z2.y;
        Log.addToLog(z1.x + " + i" + z1.y + " + " + z2.x + " + i" + z2.y + " = " + foo + " + i" + bar);
        return new Calculator(z1.x - z2.x , z1.y - z2.y);
    }
}

class Multiply
{
    public Calculator mult(Calculator z1, Calculator z2)
    {
        double x = z1.x * z2.x - z1.y * z2.y;
        double y = z1.x * z2.y + z1.y * z2.x;
        Log.addToLog("(" + z1.x + " + i" + z1.y + ")" + " * " + "(" + z2.x + " + i" + z2.y + ")" + " = " +  x + " + i" + y);
        return new Calculator(x, y);  
    }
}

class Divide
{
    public Calculator div(Calculator z1, Calculator z2)
    {
        Mod mod = new Mod();
        Conjugate con = new Conjugate();
        Multiply mult = new Multiply();

        Calculator output = mult.mult(z1,con.conjugate(z2));
        double div = (mod.mod(z1)) * (mod.mod(z2));
        return new Calculator(output.x/div,output.y/div);
    }
}