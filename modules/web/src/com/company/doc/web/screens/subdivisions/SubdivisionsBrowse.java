package com.company.doc.web.screens.subdivisions;

import com.haulmont.cuba.gui.screen.*;
import com.company.doc.entity.Subdivisions;

@UiController("doc_Subdivisions.browse")
@UiDescriptor("subdivisions-browse.xml")
@LookupComponent("subdivisionsesTable")
@LoadDataBeforeShow
public class SubdivisionsBrowse extends StandardLookup<Subdivisions> {
}