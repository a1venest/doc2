package com.company.doc.web.screens.employees;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.FileDescriptorResource;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.screen.*;
import com.company.doc.entity.Employees;

import javax.inject.Inject;


@UiController("doc_Employees.browse")
@UiDescriptor("employees-browse.xml")
@LookupComponent("employeesesTable")
@LoadDataBeforeShow
public class EmployeesBrowse extends StandardLookup<Employees> {
    @Inject
    protected GroupTable<Employees> employeesesTable;

    @Inject
    protected UiComponents uiComponents;

    @Subscribe
    protected void onInit(InitEvent event) {
        employeesesTable.addGeneratedColumn(
                "photo",
                this::renderAvatarImageComponent
        );
    }

    private Component renderAvatarImageComponent(Employees employees) {
        FileDescriptor imageFile = employees.getPhoto();
        if (imageFile == null) {
            return null;
        }
        Image photo = smallAvatarImage();
        photo.setSource(FileDescriptorResource.class)
                .setFileDescriptor(imageFile);

        return photo;
    }

    private Image smallAvatarImage() {
        Image photo = uiComponents.create(Image.class);
        photo.setScaleMode(Image.ScaleMode.CONTAIN);
        photo.setHeight("40");
        photo.setWidth("40");
        photo.setStyleName("avatar-icon-small");
        return photo;
    }
}
