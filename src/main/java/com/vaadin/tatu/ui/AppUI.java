package com.vaadin.tatu.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.addon.charts.ChartOptions;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.tatu.app.HasLogger;
import com.vaadin.tatu.ui.navigation.NavigationManager;
import com.vaadin.tatu.ui.views.AccessDeniedView;
import com.vaadin.ui.UI;

@Push
@Theme("apptheme")
@SpringUI
@Viewport("width=device-width,initial-scale=1.0,user-scalable=no")
@Title("My-Bakery")
public class AppUI extends UI implements HasLogger {

    private final SpringViewProvider viewProvider;

    private final NavigationManager navigationManager;

    private final MainView mainView;

    @Autowired
    public AppUI(SpringViewProvider viewProvider,
            NavigationManager navigationManager, MainView mainView) {
        this.viewProvider = viewProvider;
        this.navigationManager = navigationManager;
        this.mainView = mainView;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setErrorHandler(event -> {
            Throwable t = DefaultErrorHandler
                    .findRelevantThrowable(event.getThrowable());
            getLogger().error("Error during request", t);
        });

        // Set the theme ("globally") for all Charts
        ChartOptions.get(this).setTheme(new ChartsTheme());

        viewProvider.setAccessDeniedViewClass(AccessDeniedView.class);
        setContent(mainView);

        navigationManager.navigateToDefaultView();
    }

}
