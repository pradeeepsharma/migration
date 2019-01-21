package pk.playground.model;

public class Task {
    private final Operation operation;
    private int operand1;
    private int operand2;

    public Task(int operand1, int operand2, Operation operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }

    public int execute() {
        System.out.println("Consuming operation of " + operation + " is been executed on :" + operand1 + " and :" + operand2);
        switch (operation) {
            case ADD:
                return operand1 + operand2;
            case DIV:
                return operand1 / operand2;
            case MUL:
                return operand1 * operand2;
            case SUB:
                return operand1 - operand2;
            default:
                return 0;
        }
    }

    public int getOperand1() {
        return operand1;
    }

    public Operation getOperation() {
        return operation;
    }
}
