package com.company.doc.web.screens.documenttype;

import com.haulmont.cuba.gui.screen.*;
import com.company.doc.entity.DocumentType;

@UiController("doc_DocumentType.edit")
@UiDescriptor("document-type-edit.xml")
@EditedEntityContainer("documentTypeDc")
@LoadDataBeforeShow
public class DocumentTypeEdit extends StandardEditor<DocumentType> {
}