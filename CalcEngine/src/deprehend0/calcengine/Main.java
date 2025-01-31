package deprehend0.calcengine;

public class Main {

  public static void main(String[] args) {
    double[] leftVals = {100d, 25d, 225d, 11d};
    double[] rightVals = {50d, 92, 17, 3};
    char[] opCodes = {'d', 'a', 's', 'm'};
    double[] results = new double[opCodes.length];

    for(int i = 0; i < opCodes.length; i ++) {
      results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
    }

    for (double result : results) {
      System.out.println(result);
    }
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
}