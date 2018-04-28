import java.util.Scanner;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class FractionCalculator {

    public String getOperation( Scanner input) {
        String a;
        do {
            System.out.print("Please enter an operation (+, -, /, *, = or Q to quit) : ");
            a = input.nextLine();
        } while (a.equals("+") ||a.equals("-") ||a.equals("*") ||a.equals("/") ||a.equals("q") ||a.equals("Q"));
        return a;
    }

    public boolean validFraction(String input) {
        if (!input.contains("/") && isNumber(Integer.parseInt(input))) {
            return true;
        }
        if (!input.contains("-") && (input.indexOf("/") == 1) && (Integer.parseInt(input[0]) >= 0) && (Integer.parseInt(input[2]) <= 9)) {
            return true;
        } else if (input.indexOf("-") == 0 && input.indexOf("/") == 2 && Integer.parseInt(input[1]) >=0 && Integer.parseInt(input[3]) <=9) {
            return true;
        }
        return false;
    }
    public void introduction () {
        System.out.println("This program is a Fraction Calulator");
        System.out.println("This will multiply, divide, subtract and add two fraction until you type Q to quit");
        System.out.println("Please enter your fraction in the foem of a/b where a and b are integers");
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public Fraction getFraction(Scanner input) {
        String toFraction = input.nextLine();
        while (!validFraction()){
            toFraction = input.nextLine();
        }
        if (toFraction.contains("/")) {
            int slashIdx = toFraction.indexOf('/');
            int numer = (Integer.parseInt(toFraction.substring(0, slashIdx)));
            int denom = (Integer.parseInt(toFraction.substring(slashIdx + 1)));
            Fraction myFrac = new Fraction(numer, denom);
            return myFrac;
        }
        int numerator = Integer.parseInt(toFraction);
        Fraction myFraction = new Fraction(numerator);
        return myFraction;

    }
}
