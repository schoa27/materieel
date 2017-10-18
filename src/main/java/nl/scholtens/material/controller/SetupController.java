package nl.scholtens.material.controller;

import nl.scholtens.material.formobject.Body;
import nl.scholtens.material.service.SetupService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SetupController {

    Logger logger = Logger.getLogger(SetupController.class);

    @Autowired
    private SetupService setupService;

    @Value("${build.version}")
    private String buildVersion;

    @RequestMapping(value = "/setup", method = RequestMethod.GET)
    public ModelAndView instelling(ModelAndView model) throws IOException {
        model.addObject("gevuld", false);

        model.addObject("version", buildVersion);

        if (!setupService.isFileEmpty()) {
            final String[] paths = setupService.readSetupFile();
            model.addObject("xmlpath", paths[0]);
            model.addObject("imagepath", paths[1]);
        } else {
            model.addObject("xmlpath", "pad en bestand niet gevuld");
            model.addObject("imagepath", "pad niet gevuld");
        }

        model.addObject("form", new Body(buildVersion));
        model.setViewName("setupView");
        return model;
    }

    @RequestMapping(value = "/setup", method = RequestMethod.POST)
    public ModelAndView writeSetup(HttpServletRequest request, ModelAndView model) {
        model.addObject("gevuld", false);

        if (request.getParameter("padxml") != null && !request.getParameter("padxml").isEmpty()
                && !request.getParameter("padafbeelding").isEmpty()) {

            setupService.writeSetupFile(request.getParameter("padxml"), request.getParameter("padafbeelding"));

            model.addObject("gevuld", true);
        }

        if (!setupService.isFileEmpty()) {
            model.addObject("gevuld", true);
        }

        if (request.getParameter("terug") != null && request.getParameter("terug").equals("true")) {
            model.addObject("gevuld", true);
        }
        model.addObject("form", new Body(buildVersion));
        model.setViewName("setupView");
        return model;
    }

    @RequestMapping(value = "/keuze", method = RequestMethod.POST)
    public void views(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String element = request.getParameterNames().nextElement();

        if (element.contentEquals("loc")) {
            response.sendRedirect("/locs");
        }
        if (element.contentEquals("car")) {
            response.sendRedirect("/cars");
        }
        if (element.contentEquals("train")) {
            response.sendRedirect("/operators");
        }
    }

    @RequestMapping(value = "/zoeken", method = RequestMethod.GET)
    public ModelAndView searchMethodes(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (!request.getParameter("catalog").isEmpty()) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("zoek", request.getParameter("catalog"));
            mav.setViewName("forward:/zoek/catalog");
            return mav;
        }

        if (!request.getParameter("owner").isEmpty()) {
            ModelAndView mav = new ModelAndView();;
            mav.addObject("zoek", request.getParameter("owner"));
            mav.setViewName("forward:/zoek/owner");
            return mav;
        }

        if (!request.getParameter("dcc").isEmpty()) {
            ModelAndView mav = new ModelAndView();
            request.setAttribute("zoek", request.getParameter("dcc"));
            mav.addObject("zoek", request.getParameter("dcc"));
            mav.setViewName("forward:/zoek/dcc");
            return mav;
        }

        if (!request.getParameter("br").isEmpty()) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("zoek", request.getParameter("br"));
            mav.setViewName("forward:/zoek/br");
            return mav;
        }
        return null;
    }

}
