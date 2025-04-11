package deprehend0.calcengine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            performCalculations();
        } else if (args.length == 3) {
            handleCommandLine(args);
        } else if (args.length == 1 && args[0].equals("interactive")) {
            executeInteractively();
        } else {
            System.out.println(
                "Please provide an operation code (a, d, s, m) and 2 numeric values");
        }
    }

    private static void performCalculations() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(100d, 50d, MathOperation.DIVIDE);
        equations[1] = new MathEquation(25d, 92d, MathOperation.ADD);
        equations[2] = new MathEquation(225d, 17d, MathOperation.SUBTRACT);
        equations[3] = new MathEquation(11d, 3d, MathOperation.MULTIPLY);

        for (MathEquation equation: equations) {
            equation.execute();
            System.out.println(equation);
        }

        System.out.println("Average result = " + MathEquation.getAverageResult());

//        useOverloads();
    }

    private static void useOverloads() {
        System.out.println();
        System.out.println("Using execute overloads");
        System.out.println();

        MathEquation equationOverload = new MathEquation(MathOperation.DIVIDE);
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("Overload result with doubles: " + equationOverload.getResult());

        int leftInt = 9;
        int rightInt = 4;
        equationOverload.execute(leftInt, rightInt);
        System.out.println("Overload result with ints: " + equationOverload.getResult());
    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        MathOperation opCode = MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        MathEquation equation = new MathEquation(leftVal, rightVal, opCode);
        equation.execute();
        System.out.println(equation);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);
        String output = leftVal
            + " "
            + symbol
            + " "
            + rightVal
            + " = "
            + result;
        System.out.println(output);
    }

    private static char symbolFromOpCode(char opCode) {
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for (int i = 0; i < opCodes.length; i++) {
            if (opCode == opCodes[i]) {
                symbol = symbols[i];
                break;
            }
        }
        return symbol;
    }

    static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);

        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    static double execute(char opCode, double leftVal, double rightVal) {
        double result;
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
        }
        return result;
    }


    static double valueFromWord(String word) {
        String[] numberWords = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        boolean isValueSet = false;
        double value = 0;
        for (int index = 0; index < numberWords.length; index++) {
            if (word.equals(numberWords[index])) {
                value = index;
                isValueSet = true;
                break;
            }
        }

        if (!isValueSet) {
            value = Double.parseDouble(word);
        }
        return value;
    }
}