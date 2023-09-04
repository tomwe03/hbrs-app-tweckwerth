package com.uni.app.views;

import com.uni.app.views.about.AboutView;
import com.uni.app.views.main.MainView;
import com.uni.app.views.modulinformationen.ModulinformationenView;
import com.uni.app.views.registrierung.RegistrierungView;
import com.uni.app.views.stundenplanansicht.StundenplanAnsichtView;
import com.uni.app.views.stundenplanerstellen.StundenplanErstellenView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("HBRS-App-TWeckwerth");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Main", MainView.class, LineAwesomeIcon.SAFARI.create()));
        nav.addItem(new SideNavItem("About", AboutView.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("Stundenplan Erstellen", StundenplanErstellenView.class,
                LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
        nav.addItem(new SideNavItem("Stundenplan Ansicht", StundenplanAnsichtView.class,
                LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
        nav.addItem(new SideNavItem("Registrierung", RegistrierungView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new SideNavItem("Modulinformationen", ModulinformationenView.class,
                LineAwesomeIcon.FILTER_SOLID.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
