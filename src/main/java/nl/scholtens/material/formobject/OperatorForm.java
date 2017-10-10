package nl.scholtens.material.formobject;

import nl.scholtens.material.domain.Operator;

import java.util.List;

public class OperatorForm extends Body {

    private List<Operator> operators;

    private Operator operator;

    public OperatorForm(String version) {
        super(version);
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}


