package com.company.doc.web.screens.documenttype;

import com.haulmont.cuba.gui.screen.*;
import com.company.doc.entity.DocumentType;

@UiController("doc_DocumentType.browse")
@UiDescriptor("document-type-browse.xml")
@LookupComponent("documentTypesTable")
@LoadDataBeforeShow
public class DocumentTypeBrowse extends StandardLookup<DocumentType> {
}