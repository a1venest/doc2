package com.company.doc.web.screens.outgoingdocuments;

import com.haulmont.cuba.gui.screen.*;
import com.company.doc.entity.OutgoingDocuments;

@UiController("docs_OutgoingDocuments.browse")
@UiDescriptor("outgoing-documents-browse.xml")
@LookupComponent("outgoingDocumentsesTable")
@LoadDataBeforeShow
public class OutgoingDocumentsBrowse extends StandardLookup<OutgoingDocuments> {
}