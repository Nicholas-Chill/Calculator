import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    private double firstNumber;
    private double secondNumber;
    private double result;
    private String operator;

    public void calculatorInput() {
        Scanner scan = new Scanner(System.in);
        boolean isDouble = true;
        boolean correctOperator = true;
        do {
            System.out.println("---------------");
            try {
                System.out.print("Enter a number: ");
                String num = scan.nextLine();
                double num1 = Double.parseDouble(num);setFirstNumber(num1);
                System.out.print("Enter an operator: ");
                operator = scan.nextLine();
                correctOperator = correctOperator(operator);
                if (correctOperator) {
                    System.out.print("Enter a number: ");
                    num = scan.nextLine();
                    double num2 = Double.parseDouble(num);
                    setSecondNumber(num2);
                }
            } catch (NumberFormatException e) {
                isDouble = false;
                System.out.println("Invalid input");
            }
        } while (!isDouble || !correctOperator);
    }

    public void calculateResult() {
        switch (operator) {
            case "+":
                this.result = firstNumber + secondNumber;
                break;
            case "-":
                this.result = firstNumber - secondNumber;
                break;
            case "*":
                this.result = firstNumber * secondNumber;
                break;
            case "/":
                this.result = firstNumber / secondNumber;
                break;
        }
    }

    public double getResult() {
        return result;
    }

    private boolean correctOperator(String operator) {
        boolean correctOperator;
        if (Objects.equals(operator, "+") || Objects.equals(operator, "-") || Objects.equals(operator, "*")
                || Objects.equals(operator, "/")) {
            correctOperator = true;
        } else {
            correctOperator = false;
            System.out.println("Invalid operator");
        }

        return correctOperator;
    }

    private void setFirstNumber(double num) {
        this.firstNumber = num;
    }

    private void setSecondNumber(double num) {
        this.secondNumber = num;
    }

    public String newCalculation() {
        Scanner scan = new Scanner(System.in);
        String calculateAgain;
        do {
            System.out.println("Would you like to make a new calculation?");
            System.out.println("yes/no");
            System.out.print("Input: ");
            calculateAgain = scan.nextLine();
            if (!Objects.equals(calculateAgain, "yes") && !Objects.equals(calculateAgain, "no")) {
                System.out.println("You can only input 'yes' or 'no'");
            }
        } while (!Objects.equals(calculateAgain, "yes") && !Objects.equals(calculateAgain, "no"));
        return calculateAgain;
    }
}
