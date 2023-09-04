package com.uni.app.views.stundenplanerstellen;

import com.uni.app.data.entity.SamplePerson;
import com.uni.app.data.service.SamplePersonService;
import com.uni.app.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Stundenplan Erstellen")
@Route(value = "StundenplanErstellen", layout = MainLayout.class)
@Uses(Icon.class)
public class StundenplanErstellenView extends Composite<VerticalLayout> {

    public StundenplanErstellenView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        MultiSelectComboBox multiSelectComboBox = new MultiSelectComboBox();
        MultiSelectComboBox multiSelectComboBox2 = new MultiSelectComboBox();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        H6 h6 = new H6();
        ProgressBar progressBar = new ProgressBar();
        MultiSelectComboBox multiSelectComboBox3 = new MultiSelectComboBox();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        TextField textField = new TextField();
        Button buttonPrimary = new Button();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        Grid multiSelectGrid = new Grid(SamplePerson.class);
        Grid multiSelectGrid2 = new Grid(SamplePerson.class);
        HorizontalLayout layoutRow5 = new HorizontalLayout();
        Button buttonPrimary2 = new Button();
        Button buttonPrimary3 = new Button();
        Button buttonSecondary = new Button();
        Button buttonTertiary = new Button();
        Button buttonTertiary2 = new Button();
        getContent().setHeightFull();
        getContent().setWidthFull();
        layoutRow.setWidthFull();
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        multiSelectComboBox.setLabel("Semester auswählen");
        setMultiSelectComboBoxSampleData(multiSelectComboBox);
        multiSelectComboBox2.setLabel("Module auswählen");
        layoutRow2.setFlexGrow(1.0, multiSelectComboBox2);
        setMultiSelectComboBoxSampleData(multiSelectComboBox2);
        getContent().setFlexGrow(1.0, layoutRow3);
        layoutRow3.setWidthFull();
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutColumn2.setWidth(null);
        layoutColumn3.setWidth(null);
        h6.setText("Stundenplan Fortschritt:");
        progressBar.setValue(0.5);
        multiSelectComboBox3.setLabel("Wochentage");
        setMultiSelectComboBoxSampleData(multiSelectComboBox3);
        layoutRow4.setWidthFull();
        layoutRow4.addClassName(Gap.MEDIUM);
        textField.setLabel("Veranstaltungssuche");
        buttonPrimary.setText("Suche");
        layoutRow4.setAlignSelf(FlexComponent.Alignment.END, buttonPrimary);
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutColumn4.setWidth(null);
        multiSelectGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        multiSelectGrid.setWidthFull();
        layoutColumn4.setFlexGrow(1.0, multiSelectGrid);
        setGridSampleData(multiSelectGrid);
        multiSelectGrid2.setSelectionMode(Grid.SelectionMode.MULTI);
        layoutRow3.setFlexGrow(1.0, multiSelectGrid2);
        multiSelectGrid2.setHeightFull();
        setGridSampleData(multiSelectGrid2);
        layoutRow5.setWidthFull();
        layoutRow5.addClassName(Gap.MEDIUM);
        getContent().setFlexGrow(1.0, layoutRow5);
        buttonPrimary2.setText("Stundenplan ansehen");
        buttonPrimary2.setHeightFull();
        layoutRow5.setFlexGrow(1.0, buttonPrimary2);
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary3.setText("PDF Erstellen");
        buttonPrimary3.setHeightFull();
        layoutRow5.setFlexGrow(1.0, buttonPrimary3);
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary.setText("CSV Erstellen");
        buttonSecondary.setHeightFull();
        layoutRow5.setFlexGrow(1.0, buttonSecondary);
        buttonTertiary.setText("Startseite");
        buttonTertiary.setHeightFull();
        layoutRow5.setFlexGrow(1.0, buttonTertiary);
        buttonTertiary.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        buttonTertiary2.setText("Anwendung beenden");
        buttonTertiary2.setHeightFull();
        layoutRow5.setFlexGrow(1.0, buttonTertiary2);
        buttonTertiary2.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        getContent().add(layoutRow);
        layoutRow.add(layoutRow2);
        layoutRow2.add(multiSelectComboBox);
        layoutRow2.add(multiSelectComboBox2);
        getContent().add(layoutRow3);
        layoutRow3.add(layoutColumn2);
        layoutColumn2.add(layoutColumn3);
        layoutColumn3.add(h6);
        layoutColumn3.add(progressBar);
        layoutColumn2.add(multiSelectComboBox3);
        layoutColumn2.add(layoutRow4);
        layoutRow4.add(textField);
        layoutRow4.add(buttonPrimary);
        layoutRow3.add(layoutColumn4);
        layoutColumn4.add(multiSelectGrid);
        layoutRow3.add(multiSelectGrid2);
        getContent().add(layoutRow5);
        layoutRow5.add(buttonPrimary2);
        layoutRow5.add(buttonPrimary3);
        layoutRow5.add(buttonSecondary);
        layoutRow5.add(buttonTertiary);
        layoutRow5.add(buttonTertiary2);
    }

    private void setMultiSelectComboBoxSampleData(MultiSelectComboBox multiSelectComboBox) {
        multiSelectComboBox.setItems("First", "Second", "Third", "Fourth");
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
