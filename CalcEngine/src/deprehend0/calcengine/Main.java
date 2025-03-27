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
      System.out.println("Please provide an operation code (a, d, s, m) and 2 numeric values");
    }
  }

  private static void performCalculations() {
    double[] leftVals = {100d, 25d, 225d, 11d};
    double[] rightVals = {50d, 92, 17, 3};
    char[] opCodes = {'d', 'a', 's', 'm'};
    double[] results = new double[opCodes.length];

    for (int i = 0; i < opCodes.length; i++) {
      results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
    }

    for (double result : results) {
      System.out.println(result);
    }
  }

  static void executeInteractively() {
    System.out.println("Enter an operation and two numbers");
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();
    String[] parts = userInput.split(" ");
    performOperation(parts);
  }

  private static void performOperation(String[] parts) {
    char opCode = opCodeFromString(parts[0]);
    double leftVal = valueFromWord(parts[1]);
    double rightVal = valueFromWord(parts[2]);
    double result = execute(opCode, leftVal, rightVal);
    displayResult(opCode, leftVal, rightVal, result);
    System.out.println(result);
  }

  private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
    char symbol = symbolFromOpCode(opCode);
    StringBuilder builder = new StringBuilder(20);
    builder.append(leftVal);
    builder.append(" ");
    builder.append(symbol);
    builder.append(" ");
    builder.append(rightVal);
    builder.append(" = ");
    builder.append(result);
    String output = builder.toString();
    System.out.println(output);
  }

  private static char symbolFromOpCode(char opCode) {
    char[] opCodes = {'a', 's', 'm', 'd'};
    char[] symbols = {'+', '-', '*', '/'};
    char symbol = ' ';
    for (int i = 0; i < opCodes.length; i ++) {
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

  static char opCodeFromString(String operationName) {
    char opCode = operationName.charAt(0);
    return opCode;
  }


  static double valueFromWord(String word) {
    String[] numberWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
        "nine"};
    double value = 0;
    for (int index = 0; index < numberWords.length; index++) {
      if (word.equals(numberWords[index])) {
        value = index;
        break;
      }
    }
    return value;
  }
}