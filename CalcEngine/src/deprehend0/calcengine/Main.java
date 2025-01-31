package deprehend0.calcengine;

public class Main {

  public static void main(String[] args) {
    double value1 = 100d;
    double value2 = 2d;
    double result = 0d;
    char opCode = 'd'; // Operation code (a: add, s: subtract, m: multiply, d: divide)

    switch(opCode){
      case 'a':
        result = value1 + value2;
        break;
      case 's':
        result = value1 - value2;
        break;
      case 'm':
        result = value1 * value2;
        break;
      case 'd':
        if (value2 != 0)
          result = value1 / value2;
        break;
      default:
        System.out.println("Invalid opCode: " + opCode);
        result = 0.0d;
    }

    System.out.println(result);
  }
}