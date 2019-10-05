package com.medium.danieldiasjava.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.deltaspike.core.api.resourceloader.InjectableResource;

@ApplicationScoped
public class MainApplication {

    @Inject
    @InjectableResource(location="palestrante.txt")
    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public static void main(String[] args) {

        CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
        cdiContainer.boot();

        ContextControl contextControl = cdiContainer.getContextControl();
        contextControl.startContext(ApplicationScoped.class);

        MainApplication mainApplication = BeanProvider.getContextualReference(MainApplication.class);
       
        List<Palestrante> palestrantes = new ArrayList<>();

        try (BufferedReader palestranteTxt= new BufferedReader(new InputStreamReader(mainApplication.getInputStream()))) {
            palestranteTxt.lines().forEach(palestrante-> {
                String[] output = palestrante.split("-");
                palestrantes.add(new Palestrante(output[0], output[1], output[2]));
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
        palestrantes.forEach(System.out::println);
    }
}