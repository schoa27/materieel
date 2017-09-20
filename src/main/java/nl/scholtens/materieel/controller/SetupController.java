package nl.scholtens.materieel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@Controller
public class SetupController {

    @RequestMapping(value = "/setup", method = RequestMethod.GET)
    public String instelling() {
        return "setupView";
    }

    @RequestMapping(value = "/setup", method = RequestMethod.POST)
    public ModelAndView opslaan(HttpServletRequest request, ModelAndView model) {
        model.addObject("gevuld", false);

        if (!request.getParameter("padxml").isEmpty() && !request.getParameter("padafbeelding").isEmpty() ) {
            model.addObject("padxml", request.getParameter("padxml"));
            model.addObject("padafbeelding", request.getParameter("padafbeelding"));
            model.addObject("gevuld", true);
        }

        model.setViewName("setupView");
        return model;
    }

    @RequestMapping(value = "/keuze", method = RequestMethod.POST)
    public void overzichten(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Enumeration<String> names = request.getParameterNames();

        if (names.nextElement().contentEquals("loc")) {
            response.sendRedirect("/locs");
        }
        if (names.nextElement().contentEquals("car")) {
            response.sendRedirect("/cars");
        }
        if (names.nextElement().contentEquals("train")) {
            response.sendRedirect("/trains");
        }
    }
}
