package pk.playground.model;

public enum Operation {
    ADD("Addition"), SUB("Subtraction"), MUL("Multiplication"), DIV("Division");
    private String operationName;

    private Operation(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public String toString() {
        return operationName;
    }
}
