package deprehend0.calcengine;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCode;
    private double result;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathEquation(double leftVal, double rightVal, char opCode) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    void execute() {
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
        numberOfCalculations ++;
        sumOfResults += result;
    }

    public static double getAverageResult() {
        return sumOfResults / numberOfCalculations;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }
}
