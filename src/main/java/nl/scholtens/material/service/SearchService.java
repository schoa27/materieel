package nl.scholtens.material.service;

import java.util.List;
import java.util.Map;

public interface SearchService {
    Map<String, List<?>> searchOwner(String fabrikant, String file);

    Map<String, List<?>> searchCatalog(String catalog, String file);

    Map<String, List<?>> searchDccAddress(String address, String file);

    Map<String, List<?>> searchBr(String br, String file);
}
