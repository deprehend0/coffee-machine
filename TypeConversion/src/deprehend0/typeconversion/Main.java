package deprehend0.typeconversion;

public class Main {

  public static void main(String[] args) {
    float floatVal = 1.0f;
    double doubleVal = 4.0d;
    byte byteVal = 7;
    short shortVal = 7;
    long longVal = 5;

    short result1 = byteVal; // widening conversion
    short result1B = (short) longVal; // explicit narrowing conversion

    short result2 = (short) (byteVal
        - longVal); // byteVal can be widened, but longVal can't be narrowed. Now the calculation is done as a long [(long) byteval - longVal] and then the result is explicitly converted to a short

    float result3 = longVal - floatVal; // changed type of result3 from long to float because casting the float to a long will lose the potential decimal point information®®

    System.out.println("Success");
  }
}