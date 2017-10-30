package nl.scholtens.material.service;


import nl.scholtens.material.domain.OperatorTrain;

import java.util.List;

public interface OperatorService {
    List<OperatorTrain> getOperatorList(String file);


    OperatorTrain getOperatorById(String operatorId, String file);
}
