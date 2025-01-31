package deprehend0.calcengine;

public class Main {

  public static void main(String[] args) {
    double value1 = 100d;
    double value2 = 50d;
    double result = 0;
    char opCode = 'd'; // Operation code (a: add, s: subtract, m: multiply, d: divide)

    if (opCode == 'a')
      result = value1 + value2;
    else if (opCode == 's')
      result = value1 - value2;
    else if (opCode == 'm')
      result = value1 * value2;
    else if (opCode == 'd')
      result = value1 / value2;
    else
      result = 0.0d;

    System.out.println(result);
  }
}