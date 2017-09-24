package nl.scholtens.materieel.service;

import nl.scholtens.materieel.domein.Locomtive;

import java.util.List;

public interface LocService {

    List<Locomtive> getLocList(String file);
}
