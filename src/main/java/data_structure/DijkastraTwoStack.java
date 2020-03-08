package data_structure;

import java.util.stream.Stream;

public class DijkastraTwoStack {
    private Stack<Integer> values;
    private Stack<String> operators;

    public DijkastraTwoStack() {
      values = new ArrayStack<>();
      operators = new ArrayStack<>();
    }

    public int calculate(String statement) {
      String[] ss = statement.split("\\s+");
      Stream.of(ss).forEach(this::pushOperation);
      return calculateAll();
    }

    private void pushOperation(String s) {
      if (isNumeric(s))
        values.push(Integer.parseInt(s));
      else if ("+".equals(s) || "-".equals(s))
        operators.push(s);
      else if (")".equals(s))
        values.push(calculateOperation());
      else if (!"(".equals(s))
        throw new UnsupportedOperationException();
    }

    private int calculateAll() {
      String op = operators.pop();
      if (op == null)
        return values.pop();
      values.push(calculateOperation(op));
      return calculateAll();
    }

    private int calculateOperation() {
      String op = operators.pop();
      return calculateOperation(op);
    }

    private int calculateOperation(String op) {
      int v1 = values.pop();
      int v2 = values.pop();
      int r;
      if ("+".equals(op))
        return v1 + v2;
      else if ("-".equals(op))
        return v2 - v1;
      else
        throw new RuntimeException("Unknown error");
    }

    private boolean isNumeric(String s) {
      return s.chars().allMatch(Character::isDigit);
    }
  }