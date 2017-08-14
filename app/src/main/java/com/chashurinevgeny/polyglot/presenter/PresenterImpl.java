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
    public void loadListLessons(ViewInterface viewInterface) {
        viewInterface.displayListLessons(model.retrieveListLessons());
    }

    @Override
    public void loadListDetailsLesson(ViewInterface viewInterface, int idLesson) {
        viewInterface.displayListDetailsLesson(model.retrieveDetailsLesson(idLesson));
    }
}
