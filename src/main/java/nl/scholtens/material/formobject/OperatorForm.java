package nl.scholtens.material.formobject;

import nl.scholtens.material.domain.Decoder;
import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.domain.Operator;

import java.util.List;

public class OperatorForm extends Body {

    private List<Operator> operators;

    private Operator operator;

    private Locomotive locomotive;

    private Decoder decoder;


    public OperatorForm(String version, String date) {
        super(version, date);
    }

    public OperatorForm(String version, String date, Operator operator) {
        super(version, date);
        setOperator(operator);
        setLocomotive(operator);
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

    public Locomotive getLocomotive() {
        return this.locomotive;
    }

    private void setLocomotive(Operator operator) {
        if (operator.getLocomotive() != null) {
            this.locomotive = operator.getLocomotive();
            setDecoder();
        }
    }

    public Decoder getDecoder() {
        return this.decoder;
    }

    private void setDecoder() {
        if (getLocomotive().getDecoder() != null) {
            this.decoder = getLocomotive().getDecoder();
        }
    }
}


