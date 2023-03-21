package Calculator_Java_6_OOP;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {

        Calculator z1 = new Calculator(5,5);
        Calculator z2 = new Calculator(4);

        Mod mod = new Mod();
        Add add = new Add();
        Multiply mult = new Multiply();
        Divide div = new Divide();

        System.out.println(mod.mod(z1));

        System.out.println(add.add(z1, z2));
        System.out.println(Log.getLog());

        System.out.println(add.add(z1, z1));
        System.out.println(Log.getLog());

        System.out.println(mult.mult(z1, z2));
        System.out.println(Log.getLog());

        System.out.println(div.div(z1, z2));
        System.out.println(Log.getLog());
    }
}
