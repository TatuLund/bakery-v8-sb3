package com.vaadin.tatu.ui.views.admin.user;

import java.io.Serializable;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.tatu.backend.data.entity.User;
import com.vaadin.tatu.backend.service.UserService;
import com.vaadin.tatu.ui.navigation.NavigationManager;
import com.vaadin.tatu.ui.views.admin.AbstractCrudPresenter;

@SpringComponent
@ViewScope
public class UserAdminPresenter
        extends AbstractCrudPresenter<User, UserService, UserAdminView>
        implements Serializable {

    @Autowired
    public UserAdminPresenter(UserAdminDataProvider userAdminDataProvider,
            NavigationManager navigationManager, UserService service,
            BeanFactory beanFactory) {
        super(navigationManager, service, User.class, userAdminDataProvider,
                beanFactory);
    }

    public String encodePassword(String value) {
        return getService().encodePassword(value);
    }

    @Override
    protected void editItem(User item) {
        super.editItem(item);
        getView().setPasswordRequired(item.isNew());
    }
}