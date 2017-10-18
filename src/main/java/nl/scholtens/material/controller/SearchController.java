package nl.scholtens.material.controller;

import nl.scholtens.material.domain.Car;
import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.formobject.ResultForm;
import nl.scholtens.material.service.SearchService;
import nl.scholtens.material.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private SetupService setupService;

    @Value("${build.version}")
    private String buildVersion;

    @RequestMapping(value = "/zoek/owner", method = RequestMethod.GET)
    public ModelAndView searchOwner(HttpServletRequest request, HttpServletResponse response) {
        String parameter = request.getParameter("owner");
        return getModelAndView(searchService.searchOwner(parameter, getXmlPath()));
    }

    @RequestMapping(value = "/zoek/catalog", method = RequestMethod.GET)
    public ModelAndView searchCatalog(HttpServletRequest request, HttpServletResponse response) {
        String parameter = request.getParameter("catalog");
        return getModelAndView(searchService.searchCatalog(parameter, getXmlPath()));
    }

    @RequestMapping(value = "/zoek/dcc", method = RequestMethod.GET)
    public ModelAndView searchDcc(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
        String parameter = request.getParameter("dcc");
        return getModelAndView(searchService.searchDccAddress(parameter, getXmlPath()));
    }

    @RequestMapping(value = "/zoek/br", method = RequestMethod.GET)
    public ModelAndView searchBr(HttpServletRequest request, HttpServletResponse response) {
        String parameter = request.getParameter("br");
        return getModelAndView(searchService.searchBr(parameter, getXmlPath()));
    }

    private ModelAndView getModelAndView(Map<String, List<?>> list) {
        ResultForm form = new ResultForm(buildVersion);

        ModelAndView mav = new ModelAndView();
        form.setLocomotives((List<Locomotive>) list.get("loc"));
        if (list.get("car") == null || !list.get("car").isEmpty()) {
            form.setCars((List<Car>) list.get("car"));
        }
        mav.addObject("form", mav);
        mav.setViewName("resultView");
        return mav;
    }

    private String getXmlPath() {
        final String[] paths = readSetupFile();
        return paths[0];
    }

    private String[] readSetupFile() {
        return setupService.readSetupFile();
    }
}
