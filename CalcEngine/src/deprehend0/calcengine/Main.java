package deprehend0.calcengine;

public class Main {

  public static void main(String[] args) {
    double[] leftVals = {100d, 25d, 225d, 11d};
    double[] rightVals = {50d, 92, 17, 3};
    char[] opCodes = {'d', 'a', 's', 'm'};
    double[] results = new double[opCodes.length];

    for(int i = 0; i < opCodes.length; i ++) {
      switch (opCodes[i]) {
        case 'a':
          results[i] = leftVals[i] + rightVals[i];
          break;
        case 's':
          results[i] = leftVals[i] - rightVals[i];
          break;
        case 'm':
          results[i] = leftVals[i] * rightVals[i];
          break;
        case 'd':
          results[i] = rightVals[i] != 0 ? leftVals[i] / rightVals[i] : 0;
          break;
        default:
          System.out.println("Invalid opCode: " + opCodes[i]);
          results[i] = 0.0d;
      }
    }

    for (double result : results) {
      System.out.println(result);
    }
  }
}