package nl.scholtens.material.controller;

import nl.scholtens.material.formobject.Body;
import nl.scholtens.material.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SetupController {

    @Autowired
    private SetupService setupService;

    @RequestMapping(value = "/setup", method = RequestMethod.GET)
    public ModelAndView instelling(ModelAndView model) {
        model.addObject("form", new Body());
        model.setViewName("setupView");
        return model;
    }

    @RequestMapping(value = "/setup", method = RequestMethod.POST)
    public ModelAndView writeSetup(HttpServletRequest request, ModelAndView model) {
        model.addObject("gevuld", false);

        if (request.getParameter("padxml") != null && !request.getParameter("padxml").isEmpty()
                && !request.getParameter("padafbeelding").isEmpty()               ) {

            setupService.writeSetupFile(request.getParameter("padxml"), request.getParameter("padafbeelding"));

            model.addObject("gevuld", true);
        }

        if (setupService.readSetupFile().length > 0) {
            model.addObject("gevuld", true);
        }

        if (request.getParameter("terug") != null && request.getParameter("terug").equals("true")) {
            model.addObject("gevuld", true);
        }
        model.addObject("form", new Body());
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
}
