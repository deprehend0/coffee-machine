package deprehend0.calcengine;

public class Main {

  public static void main(String[] args) {
    double value1 = 100d;
    double value2 = 0d;
    double result = 0d;
    char opCode = 'd'; // Operation code (a: add, s: subtract, m: multiply, d: divide)

    if (opCode == 'a')
      result = value1 + value2;
    else if (opCode == 's')
      result = value1 - value2;
    else if (opCode == 'm')
      result = value1 * value2;
    else if (opCode == 'd') {
      if (value2 != 0)
        result = value1 / value2;
    }
    else {
      System.out.println("Invalid opCode: " + opCode);
      result = 0.0d;
    }

    System.out.println(result);
  }
}