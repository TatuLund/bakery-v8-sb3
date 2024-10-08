package com.vaadin.tatu.ui.views.admin.product;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.tatu.backend.data.entity.Product;
import com.vaadin.tatu.backend.service.ProductService;
import com.vaadin.tatu.ui.navigation.NavigationManager;
import com.vaadin.tatu.ui.views.admin.AbstractCrudPresenter;

@SpringComponent
@ViewScope
public class ProductAdminPresenter extends
        AbstractCrudPresenter<Product, ProductService, ProductAdminView> {

    @Autowired
    public ProductAdminPresenter(
            ProductAdminDataProvider productAdminDataProvider,
            NavigationManager navigationManager, ProductService service,
            BeanFactory beanFactory) {
        super(navigationManager, service, Product.class,
                productAdminDataProvider, beanFactory);
    }
}
