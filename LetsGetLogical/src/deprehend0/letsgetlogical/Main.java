package deprehend0.letsgetlogical;

public class Main {

  public static void main(String[] args) {
    int students = 150;
    int rooms = 0;

    if (rooms != 0 && students / rooms > 30) // a single '&' will still result in possible divide by zero exception because it still calculates both sides of the &. With the double && it will only calculate the left side if rooms == 0.
      System.out.println("Crowded");

    System.out.println("");
    System.out.println("*** end of program ***");
  }
}