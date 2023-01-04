import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String calculateAgain;
        do {
            Calculator calc = new Calculator();
            calc.calculatorInput();
            calc.calculateResult();
            System.out.println("Result: " + calc.getResult());
            calculateAgain = calc.newCalculation();
        } while (Objects.equals(calculateAgain, "yes"));

    }
}