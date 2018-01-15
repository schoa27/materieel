package nl.scholtens.material.controller;

import nl.scholtens.material.formobject.Body;
import nl.scholtens.material.formobject.SessionForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SetupController extends IoController {

    Logger logger = Logger.getLogger(SetupController.class);

    @Value("${build.version}")
    private String buildVersion;

    private SessionForm sessionForm = new SessionForm();

    @RequestMapping(value = "/setup", method = RequestMethod.GET)
    public ModelAndView instelling(HttpServletRequest request, ModelAndView model) throws IOException {
        createSessionForm(request);

        model.addObject("gevuld", false);
        model.addObject("version", buildVersion);

        if (!getSetupService().isFileEmpty()) {
            getFileParameters(model);
        } else {
            model.addObject("xmlpath", "pad en bestand niet gevuld");
            model.addObject("imagepathsmall", "pad niet gevuld");
            model.addObject("imagepathlarge", "pad niet gevuld");
        }

        model.addObject("form", new Body(buildVersion, sessionForm.getDate()));
        model.setViewName("setupView");
        return model;
    }

    @RequestMapping(value = "/setup", method = RequestMethod.POST)
    public ModelAndView writeSetup(HttpServletRequest request, ModelAndView model) {
        intitSessionForm();

        model.addObject("gevuld", writepaths(request));

//
//        if (request.getParameter("pathxml") == null
//                || !request.getParameter("pathxml").isEmpty()
//                || !request.getParameter("pathimagesmall").isEmpty()
//                || !request.getParameter("pathimagelarge").isEmpty()) {
//
//        }

        if (!getSetupService().isFileEmpty()) {
            model.addObject("gevuld", true);
        }

        if (request.getParameter("terug") != null && request.getParameter("terug").equals("true")) {
            model.addObject("gevuld", true);
        }

        model.addObject("form", new Body(buildVersion, sessionForm.getDate()));
        getFileParameters(model);
        model.setViewName("setupView");
        return model;
    }

    @RequestMapping(value = "/keuze", method = RequestMethod.POST)
    public void views(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sessionForm.setMethode(true ,false);
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
        sessionForm.setMethode(false ,true);

        if (request.getParameter("catalog") != null)  {
            if ( !request.getParameter("catalog").isEmpty()) {
                sessionForm.setSearchParameter(request.getParameter("catalog"));
                sessionForm.setSearchMethode("catalog");
            }
        }
        if (sessionForm.getSearchParameter() != null && sessionForm.getSearchMethode().equals("catalog")) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("zoek", sessionForm.getSearchParameter());
            mav.setViewName("forward:/zoek/catalog");
            return mav;
        }

        if (request.getParameter("owner") != null)  {
            if ( !request.getParameter("owner").isEmpty()) {
                sessionForm.setSearchParameter(request.getParameter("owner"));
                sessionForm.setSearchMethode("owner");
            }
        }
        if (sessionForm.getSearchParameter() != null && sessionForm.getSearchMethode().equals("owner")) {
            ModelAndView mav = new ModelAndView();;
            mav.addObject("zoek", request.getParameter("owner"));
            mav.setViewName("forward:/zoek/owner");
            return mav;
        }

        if (request.getParameter("dcc") != null)  {
            if ( !request.getParameter("dcc").isEmpty()) {
                sessionForm.setSearchParameter(request.getParameter("dcc"));
                sessionForm.setSearchMethode("dcc");
            }
        }
        if (sessionForm.getSearchParameter() != null && sessionForm.getSearchMethode().equals("dcc")) {
            ModelAndView mav = new ModelAndView();;
            mav.addObject("zoek", request.getParameter("dcc"));
            mav.setViewName("forward:/zoek/dcc");
            return mav;
        }

        if (request.getParameter("br") != null)  {
            if ( !request.getParameter("br").isEmpty()) {
                sessionForm.setSearchParameter(request.getParameter("br"));
                sessionForm.setSearchMethode("br");
            }
        }
        if (sessionForm.getSearchParameter() != null && sessionForm.getSearchMethode().equals("br")) {
            ModelAndView mav = new ModelAndView();;
            mav.addObject("zoek", request.getParameter("br"));
            mav.setViewName("forward:/zoek/br");
            return mav;
        }
        return new ModelAndView("forward:/material");
    }

    private void createSessionForm(HttpServletRequest request) {
        sessionForm.setDate(getSetupService().getDate(request.getParameter("lang")));
        request.getSession().setAttribute("sessionform", sessionForm);
    }

    private void intitSessionForm() {
        sessionForm.setSearchMethode(null);
        sessionForm.setSearchParameter(null);
    }

    private void getFileParameters(ModelAndView model) {
        final String[] paths = getSetupService().readSetupFile();
        model.addObject("xmlpath", paths[0]);
        model.addObject("imagepathsmall", paths[1]);
        model.addObject("imagepathlarge", paths[2]);
        model.addObject("local", LocaleContextHolder.getLocale().getLanguage());
    }

    private boolean writepaths(HttpServletRequest request) {
        if (request.getParameter("pathxml") != null
                && !request.getParameter("pathxml").isEmpty()
                && !request.getParameter("pathimagesmall").isEmpty()
                && !request.getParameter("pathimagelarge").isEmpty()) {

            String paths[] = { request.getParameter("pathxml"),
                    request.getParameter("pathimagesmall"),
                    request.getParameter("pathimagelarge") };

            getSetupService().writeSetupFile(paths);
            return true;

        }
        return false;
    }
}
