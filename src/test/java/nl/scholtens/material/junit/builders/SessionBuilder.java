package nl.scholtens.material.junit.builders;

import nl.scholtens.material.formobject.SessionForm;

import java.util.Date;

public class SessionBuilder {

    protected SessionForm creatSessionForm() {
        SessionForm sessionForm = new SessionForm();
        sessionForm.setDate(new Date().toString());
        return sessionForm;
    }
}
