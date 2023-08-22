package com.company.doc.web.screens.proctask;

import com.haulmont.bpm.entity.ProcActor;
import com.haulmont.bpm.entity.ProcInstance;
import com.haulmont.bpm.entity.ProcRole;
import com.haulmont.bpm.gui.action.StartProcessAction;
import com.haulmont.bpm.gui.procactionsfragment.ProcActionsFragment;
import com.haulmont.bpm.service.BpmEntitiesService;
import com.haulmont.bpm.service.ProcessRuntimeService;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.doc.entity.OutgoingDocuments;
import com.haulmont.cuba.gui.util.OperationResult;
import com.company.doc.entity.Employees;
import com.company.doc.entity.Subdivisions;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@UiController("bpm$ProcTask2.edit")
@UiDescriptor("proc-task-edit.xml")
@EditedEntityContainer("procTaskDc")
@LoadDataBeforeShow
public class ProcTaskEdit extends StandardEditor<OutgoingDocuments> {
    public static final String PROCESS_CODE = "taskExecution-1";

    @Inject
    protected ProcActionsFragment procActionsFragment;

    @Inject
    protected BpmEntitiesService bpmEntitiesService;

    @Inject
    protected ProcessRuntimeService processRuntimeService;

    @Inject
    private MessageBundle messageBundle;

    @Inject
    private Notifications notifications;

    @Inject
    private Metadata metadata;

    @Inject
    private Messages messages;

    @Inject
    private InstanceLoader<OutgoingDocuments> outgoingDocumentsDl;

    @Subscribe("startProcessProgrammaticallyBtn")
    private void onStartProcessProgrammaticallyBtnClick(Button.ClickEvent event) {

        commitChanges()
                .then(() -> {

                    BpmEntitiesService.ProcInstanceDetails procInstanceDetails = new BpmEntitiesService.ProcInstanceDetails(PROCESS_CODE)
                            .addProcActor("initiator", getEditedEntity().getInitiator().getUser())
                            .addProcActor("divisionHead", getEditedEntity().getDivisionHead().getUser())
                            .addProcActor("signatory", getEditedEntity().getSignatory().getUser())
                            .addProcActor("executor", getEditedEntity().getExecutor().getUser())

                            .setEntity(getEditedEntity());


                    ProcInstance procInstance = bpmEntitiesService.createProcInstance(procInstanceDetails);


                    HashMap<String, Object> processVariables = new HashMap<>();
                    processVariables.put("acceptanceRequired", getEditedEntity().getAcceptanceRequired());


                    processRuntimeService.startProcess(procInstance, "Process started programmatically", processVariables);
                    notifications.create()
                            .withCaption(messageBundle.getMessage("processStarted"))
                            .withType(Notifications.NotificationType.HUMANIZED)
                            .show();

                    initProcActionsFragment();
                });
    }

    private void initProcActionsFragment() {
        procActionsFragment.initializer()
                .standard()
                .setBeforeStartProcessPredicate(() -> {

                    if (commitChanges().getStatus() == OperationResult.Status.SUCCESS) {
                        ProcInstance procInstance = procActionsFragment.getProcInstance();
                        ProcActor initiatorProcActor = createProcActor("initiator", procInstance, getEditedEntity().getInitiator());
                        ProcActor divisionHeadProcActor = createProcActor("divisionHead", procInstance, getEditedEntity().getDivisionHead());
                        ProcActor signatoryProcActor = createProcActor("signatory", procInstance, getEditedEntity().getSignatory());
                        ProcActor executorProcActor = createProcActor("executor", procInstance, getEditedEntity().getExecutor());
                        Set<ProcActor> procActors = new HashSet<>();
                        procActors.add(initiatorProcActor);
                        procActors.add(executorProcActor);
                        procActors.add(signatoryProcActor);
                        procActors.add(divisionHeadProcActor);
                        procInstance.setProcActors(procActors);
                        return true;
                    }
                    return false;
                })
                .setStartProcessActionProcessVariablesSupplier(() -> {

                    Map<String, Object> processVariables = new HashMap<>();
                    processVariables.put("acceptanceRequired", getEditedEntity().getAcceptanceRequired());
                    return processVariables;
                })
                .setAfterStartProcessListener(() -> {

                    notifications.create()
                            .withCaption(messages.getMessage(ProcActionsFragment.class,"processStarted"))
                            .withType(Notifications.NotificationType.HUMANIZED)
                            .show();
                    initProcActionsFragment();
                    outgoingDocumentsDl.setEntityId(getEditedEntity().getId());
                    outgoingDocumentsDl.load();
                })
                .setAfterCompleteTaskListener(() -> {
                    notifications.create()
                            .withCaption(messages.getMessage(ProcActionsFragment.class,"taskCompleted"))
                            .withType(Notifications.NotificationType.HUMANIZED)
                            .show();
                    initProcActionsFragment();
                    outgoingDocumentsDl.setEntityId(getEditedEntity().getId());
                    outgoingDocumentsDl.load();
                })
                .init(PROCESS_CODE, getEditedEntity());
    }

    private ProcActor createProcActor(String procRoleCode, ProcInstance procInstance, Employees user) {
        ProcActor initiatorProcActor = metadata.create(ProcActor.class);
        initiatorProcActor.setUser(user.getUser());
        ProcRole initiatorProcRole = bpmEntitiesService.findProcRole(PROCESS_CODE, procRoleCode, View.MINIMAL);
        initiatorProcActor.setProcRole(initiatorProcRole);
        initiatorProcActor.setProcInstance(procInstance);
        return initiatorProcActor;
    }


    private void changeStartProcessBtnCaption() {
        StartProcessAction startProcessAction = procActionsFragment.getStartProcessAction();
        if (startProcessAction != null) {
            startProcessAction.setCaption("Start process using ProcActionsFragment");
        }
    }
}