package deprehend0.calcengine;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private MathOperation opCode;
    private double result;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public MathEquation(MathOperation opCode) {
        this.opCode = opCode;
    }

    public MathEquation(double leftVal, double rightVal, MathOperation opCode) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public void execute() {
        switch (opCode) {
            case ADD:
                result = leftVal + rightVal;
                break;
            case SUBTRACT:
                result = leftVal - rightVal;
                break;
            case MULTIPLY:
                result = leftVal * rightVal;
                break;
            case DIVIDE:
                result = rightVal != 0 ? leftVal / rightVal : 0;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
        }
        numberOfCalculations ++;
        sumOfResults += result;
    }

    public void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }

    public void execute(int leftVal, int rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();

        result = (int) result;
    }

    @Override
    public String toString() {
        char symbol = opCode.getSymbol();
        String output = leftVal
            + " "
            + symbol
            + " "
            + rightVal
            + " = "
            + result;
        return output;
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

    public void setOpCode(MathOperation opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }
}
