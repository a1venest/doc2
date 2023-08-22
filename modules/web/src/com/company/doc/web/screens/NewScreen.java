package com.company.doc.web.screens;

import com.haulmont.bpm.gui.form.ProcForm;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import java.util.Map;

@UiController("screen")
@UiDescriptor("new-screen.xml")
public class NewScreen extends Screen {
    public interface NewForm extends ProcForm{
        @Override
        Map<String, Object> getFormResult();
    }
}