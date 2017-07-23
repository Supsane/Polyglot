package com.chashurinevgeny.polyglot.presenter;

import com.chashurinevgeny.polyglot.model.ModelInterface;
import com.chashurinevgeny.polyglot.view.ViewInterface;

/**
 * Created by Chashurin Evgeny on 23.07.2017.
 */

public class PresenterImpl implements PresenterInterface {

    private final ModelInterface model;

    public PresenterImpl(ModelInterface model) {
        this.model = model;
    }

    @Override
    public void loadInformation(ViewInterface viewInterface) {
        viewInterface.displayInfo(model.retrieveInfo());
    }
}
