package nl.scholtens.material.service;

import nl.scholtens.material.domain.Car;
import nl.scholtens.material.domain.Locomotive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private LocService locService;

    @Autowired
    private CarService carService;

    @Override
    public Map<String, List<?>> searchOwner(String owner, String file) {
        Map<String, List<?>> ownerList = new HashMap<String, List<?>>();
        ownerList.put("loc", getLocomotivesFromOwner(owner, file));
        ownerList.put("car", getCarsFromOwner(owner, file));
        return ownerList;
    }

    @Override
    public Map<String, List<?>> searchCatalog(String catalog, String file) {
        Map<String, List<?>> catlogList = new HashMap<String, List<?>>();
        catlogList.put("loc", getLocomotivesByCatalog(catalog, file));
        catlogList.put("car", getCarsByCatalog(catalog, file));
        return catlogList;
    }

    @Override
    public Map<String, List<?>> searchDccAddress(String address, String file) {
        Map<String, List<?>> addressList = new HashMap<String, List<?>>();
        addressList.put("loc", getLocomotivesByDccAddress(address, file));
        addressList.put("car", getCarsByDccAddress(address, file));
        return addressList;
    }

    @Override
    public Map<String, List<?>> searchBr(String br, String file) {
        Map<String, List<?>> brList = new HashMap<String, List<?>>();
        brList.put("loc", getLocomotiveByBr(br, file));
        return brList;
    }

    private List<Locomotive> getLocomotiveByBr(String br, String file) {
        return getLocomotives(file)
                .stream()
                .filter(locomotive -> locomotive.getId() != null)
                .filter(locomotive -> locomotive.getId().toUpperCase().contains(br.toUpperCase()))
                .collect(Collectors.toList());
    }

//    private List<Locomotive> getLocomotivesByDccAddress(String address, String file) {
//        return getLocomotives(file)
//                .stream()
//                .filter(locomotive -> locomotive.getDecoder() != null)
//                .filter(locomotive -> locomotive.getDecoder().getAddress().equals(Integer.parseInt(address))).
//                collect(Collectors.toList());
//    }
    private List<Locomotive> getLocomotivesByDccAddress(String address, String file) {
        return getLocomotives(file)
                .stream()
                .filter(locomotive -> locomotive.getDecoder().getAddress() != null)
                .filter(locomotive -> locomotive.getDecoder().getAddress().equals(Integer.parseInt(address))).
                        collect(Collectors.toList());
    }

    private List<Car> getCarsByDccAddress(String address, String file) {
        return getCars(file)
                .stream()
                .filter(car -> car.getDecoder() != null)
                .filter(car -> car.getDecoder().getAddress().equals(Integer.parseInt(address)))
                .collect(Collectors.toList());
    }

    private List<Locomotive> getLocomotivesFromOwner(String owner, String file) {
        return getLocomotives(file)
                .stream()
                .filter(locomotive -> locomotive.getOwner() != null)
                .filter(locomotive -> locomotive.getOwner().toUpperCase().contains(owner.toUpperCase()))
                .collect(Collectors.toList());
    }

    private List<Car> getCarsFromOwner(String owner, String file) {
        return getCars(file)
                .stream()
                .filter(car -> car.getManufactor() != null)
                .filter(car -> car.getManufactor().toUpperCase().contains(owner.toUpperCase()))
                .collect(Collectors.toList());
    }

    private List<Locomotive> getLocomotivesByCatalog(String catalog, String file) {
        return getLocomotives(file)
               .stream()
               .filter(locomotive -> locomotive.getCatalogNumber() != null)
               .filter(locomotive -> locomotive.getCatalogNumber().toUpperCase().contains(catalog.toUpperCase()))
               .collect(Collectors.toList());
    }

    private List<Car> getCarsByCatalog(String catalog, String file) {
        return getCars(file)
                .stream()
                .filter(car -> car.getCatalognr() != null)
                .filter(car -> car.getCatalognr().toUpperCase().contains(catalog.toUpperCase()))
                .collect(Collectors.toList());
    }

    private List<Locomotive> getLocomotives(String file) {
        return locService.getLocList(file);
    }

    private List<Car> getCars(String file) {
        return carService.getCarList(file);
    }
}
