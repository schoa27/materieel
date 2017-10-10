package nl.scholtens.material.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MaterieelController {

    @RequestMapping(value = "/material", method = RequestMethod.GET)
    public void start(HttpServletResponse response) throws IOException {
        response.sendRedirect("/setup");
    }
}


