package nl.scholtens.material.service;

import nl.scholtens.material.domain.Locomotive;

import java.util.List;

public interface LocService {

    List<Locomotive> getLocList(String file);

    Locomotive getLoc(String locId, String file);

    Locomotive getLocById(String locId, String file);
}
