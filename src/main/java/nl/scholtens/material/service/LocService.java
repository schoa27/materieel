package nl.scholtens.material.service;

import nl.scholtens.material.domain.Locomtive;

import java.util.List;

public interface LocService {

    List<Locomtive> getLocList(String file);
}
