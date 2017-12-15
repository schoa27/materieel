package nl.scholtens.material.formobject;

public class SessionForm {

    private String date;

    private Boolean search;

    private Boolean list;

    private String searchParameter;

    private String searchMethode;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getSearch() {
        return search;
    }

    public void setSearch(Boolean search) {
        this.search = search;
    }

    public Boolean getList() {
        return list;
    }

    public void setList(Boolean list) {
        this.list = list;
    }

    public void setMethode(boolean list, boolean search) {
        setList(list);
        setSearch(search);
    }

    public String getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(String searchParameter) {
        this.searchParameter = searchParameter;
    }

    public String getSearchMethode() {
        return searchMethode;
    }

    public void setSearchMethode(String searchMethode) {
        this.searchMethode = searchMethode;
    }
}
