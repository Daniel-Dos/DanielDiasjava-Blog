package com.medium.danieldiasjava.app;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;
import org.apache.deltaspike.core.api.provider.BeanProvider;

@ApplicationScoped
public class CDIApplication {
    public static void main(String[] args) {

        CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
        cdiContainer.boot();

        ContextControl contextControl = cdiContainer.getContextControl();
        contextControl.startContext(ApplicationScoped.class);

        Pessoa pessoa = BeanProvider.getContextualReference(Pessoa.class, false);

        System.out.println("Olá ".concat(pessoa.getNome())
                                 .concat(" sua idade é: ") + pessoa.getIdade());
    }
}