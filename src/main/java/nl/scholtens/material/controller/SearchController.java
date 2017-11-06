package nl.scholtens.material.controller;

import nl.scholtens.material.domain.Waggon;
import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.formobject.ResultForm;
import nl.scholtens.material.formobject.SessionForm;
import nl.scholtens.material.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController extends IoController {

    @Autowired
    private SearchService searchService;

    @Value("${build.version}")
    private String buildVersion;

    @RequestMapping(value = "/zoek/owner", method = RequestMethod.GET)
    public ModelAndView searchOwner(HttpServletRequest request, HttpServletResponse response) {
        return getModelAndView(request, searchService.searchOwner(getSessionForm(request).getSearchParameter(), getXmlPath()));
    }

    @RequestMapping(value = "/zoek/catalog", method = RequestMethod.GET)
    public ModelAndView searchCatalog(HttpServletRequest request, HttpServletResponse response) {
        return getModelAndView(request, searchService.searchCatalog(getSessionForm(request).getSearchParameter(), getXmlPath()));
    }

    @RequestMapping(value = "/zoek/dcc", method = RequestMethod.GET)
    public ModelAndView searchDcc(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
        return getModelAndView(request, searchService.searchDccAddress(getSessionForm(request).getSearchParameter(), getXmlPath()));
    }

    @RequestMapping(value = "/zoek/br", method = RequestMethod.GET)
    public ModelAndView searchBr(HttpServletRequest request, HttpServletResponse response) {
        return getModelAndView(request, searchService.searchBr(getSessionForm(request).getSearchParameter(), getXmlPath()));
    }

    private ModelAndView getModelAndView(HttpServletRequest request, Map<String, List<?>> list) {
        ResultForm form = new ResultForm(buildVersion, (String) request.getSession().getAttribute("lang"));
        request.getSession().setAttribute("search", true);

        ModelAndView mav = new ModelAndView();
        form.setLocomotives((List<Locomotive>) list.get("loc"));
        if (list.get("car") != null ) {
            if (!list.get("car").isEmpty()) {
                form.setWaggons((List<Waggon>) list.get("car"));
            }
        }
        mav.addObject("form", form);
        mav.setViewName("resultView");
        return mav;
    }

    private SessionForm getSessionForm(HttpServletRequest request) {
        return (SessionForm) request.getSession().getAttribute("sessionform");
    }
}
