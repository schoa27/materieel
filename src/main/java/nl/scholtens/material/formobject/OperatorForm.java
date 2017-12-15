package nl.scholtens.material.formobject;

import nl.scholtens.material.domain.Decoder;
import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.domain.OperatorTrain;

import java.util.List;

public class OperatorForm extends Body {

    private List<OperatorTrain> operatorTrains;

    private OperatorTrain operatorTrain;

    private Locomotive locomotive;

    private Decoder decoder;


    public OperatorForm(String version, String date) {
        super(version, date);
    }

    public OperatorForm(String version, String date, OperatorTrain operatorTrain) {
        super(version, date);
        setOperatorTrain(operatorTrain);
        setLocomotive(operatorTrain);
    }

    public OperatorForm(OperatorTrain operatorTrain) {
        setOperatorTrain(operatorTrain);
        setLocomotive(operatorTrain);
    }

    public List<OperatorTrain> getOperatorTrains() {
        return operatorTrains;
    }

    public void setOperatorTrains(List<OperatorTrain> operatorTrains) {
        this.operatorTrains = operatorTrains;
    }

    public OperatorTrain getOperatorTrain() {
        return operatorTrain;
    }

    public void setOperatorTrain(OperatorTrain operatorTrain) {
        this.operatorTrain = operatorTrain;
    }

    public Locomotive getLocomotive() {
        return this.locomotive;
    }

    private void setLocomotive(OperatorTrain operatorTrain) {
        if (operatorTrain != null) {
            if (operatorTrain.getLocomotive() != null) {
                this.locomotive = operatorTrain.getLocomotive();
                setDecoder();
            }
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


