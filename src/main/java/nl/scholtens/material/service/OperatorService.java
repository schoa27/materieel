package nl.scholtens.material.service;


import nl.scholtens.material.domain.Operator;

import java.util.List;

public interface OperatorService {
    List<Operator> getOperatorList(String file);
}
