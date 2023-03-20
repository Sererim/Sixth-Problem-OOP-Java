package Calculator_Java_5_OOP;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {

        ArrayList<Calculator> calc = new ArrayList<>();

        calc.add(new Calculator());
        calc.add(new Calculator(1,1));
        calc.add(new Calculator(5));
        calc.add(new Calculator(5));

        System.out.println(Calculator.mult(calc.get(2), calc.get(2))); 
        System.out.println(Calculator.log);

        System.out.println(Calculator.add(calc.get(1),calc.get(0)));
        System.out.println(Calculator.log);
    }
}
