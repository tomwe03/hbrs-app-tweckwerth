package com.uni.app.views.stundenplanansicht;

import com.uni.app.data.entity.SamplePerson;
import com.uni.app.data.service.SamplePersonService;
import com.uni.app.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Stundenplan Ansicht")
@Route(value = "StundenplanAnsicht", layout = MainLayout.class)
@Uses(Icon.class)
public class StundenplanAnsichtView extends Composite<VerticalLayout> {

    public StundenplanAnsichtView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H1 h1 = new H1();
        Grid minimalistGrid = new Grid(SamplePerson.class);
        HorizontalLayout layoutRow = new HorizontalLayout();
        Button buttonPrimary = new Button();
        Button buttonSecondary = new Button();
        Button buttonSecondary2 = new Button();
        Button buttonTertiary = new Button();
        Button buttonTertiary2 = new Button();
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidthFull();
        h1.setText("Dein Stundenplan");
        minimalistGrid.addThemeVariants(GridVariant.LUMO_COMPACT, GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS);
        layoutColumn2.setFlexGrow(1.0, minimalistGrid);
        minimalistGrid.setWidthFull();
        setGridSampleData(minimalistGrid);
        layoutRow.setWidthFull();
        layoutRow.addClassName(Gap.MEDIUM);
        getContent().setFlexGrow(1.0, layoutRow);
        buttonPrimary.setText("PDF Erstellen");
        layoutRow.setFlexGrow(1.0, buttonPrimary);
        buttonPrimary.setHeightFull();
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary.setText("CSV Erstellen");
        layoutRow.setFlexGrow(1.0, buttonSecondary);
        buttonSecondary.setHeightFull();
        buttonSecondary2.setText("Zurück");
        layoutRow.setFlexGrow(1.0, buttonSecondary2);
        buttonSecondary2.setHeightFull();
        buttonTertiary.setText("Zur Startseite");
        layoutRow.setFlexGrow(1.0, buttonTertiary);
        buttonTertiary.setHeightFull();
        buttonTertiary.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        buttonTertiary2.setText("Anwendung Beenden");
        layoutRow.setFlexGrow(1.0, buttonTertiary2);
        buttonTertiary2.setHeightFull();
        buttonTertiary2.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        getContent().add(layoutColumn2);
        layoutColumn2.add(h1);
        layoutColumn2.add(minimalistGrid);
        getContent().add(layoutRow);
        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonSecondary);
        layoutRow.add(buttonSecondary2);
        layoutRow.add(buttonTertiary);
        layoutRow.add(buttonTertiary2);
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
