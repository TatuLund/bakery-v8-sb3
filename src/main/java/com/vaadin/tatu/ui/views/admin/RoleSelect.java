package com.vaadin.tatu.ui.views.admin;

import com.vaadin.tatu.backend.data.Role;
import com.vaadin.ui.ComboBox;

public class RoleSelect extends ComboBox<String> {

    public RoleSelect() {
        setCaption("Role");
        setEmptySelectionAllowed(false);
        setItems(Role.getAllRoles());
        setTextInputAllowed(false);
    }
}
