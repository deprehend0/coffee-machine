package deprehend0.operatorprecedence;

public class Main {
    public static void main(String[] args) {
        int valA = 21;
        int valB = 6;
        int valC = 3;
        int valD = 1;

        int result1 = valA - valB / valC; // == 21 - (6 / 3) = 21 - 2 = 19
        int result2 = (valA - valB) / valC; // == (21 - 6) / 3 = 15 / 3 = 5

        System.out.println(result1);
        System.out.println(result2);

        int result3 = valA / valC * valD + valB; // == ((21 / 3) * 1) + 6 = 7 * 1 + 6 = 7 + 6 = 13
        int result4 = valA / (valC * (valD + valB)); // == 21 / (3 * (1 + 6)) = 21 / (3 * 7) = 21 / 21 = 1

        System.out.println(result3);
        System.out.println(result4);
    }
}