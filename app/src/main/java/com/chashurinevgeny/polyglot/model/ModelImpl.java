package com.chashurinevgeny.polyglot.model;

import java.util.List;

/**
 * Created by Chashurin Evgeny on 16.07.2017.
 */

public class ModelImpl implements ModelInterface {
    @Override
    public List<Lessons.LessonExample> retrieveInfo() {

        return Lessons.getLessonExample();
    }
}
