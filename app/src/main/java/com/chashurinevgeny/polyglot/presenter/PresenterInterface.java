package com.chashurinevgeny.polyglot.presenter;

import com.chashurinevgeny.polyglot.view.ViewInterface;

/**
 * Created by Chashurin Evgeny on 16.07.2017.
 */

public interface PresenterInterface {
    void loadListLessons(ViewInterface viewInterface);
    void loadListDetailsLesson(ViewInterface viewInterface, int idLesson);
}
