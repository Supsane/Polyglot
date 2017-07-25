package com.chashurinevgeny.polyglot.model;

import java.util.List;

/**
 * Created by Chashurin Evgeny on 16.07.2017.
 */

public class ModelImpl implements ModelInterface {
    @Override
    public List<Lessons.LessonExample> retrieveListLessons() {

        return Lessons.getLessonExample();
    }

    @Override
    public List<DetailsLesson.DetailsLessonsExample> retrieveDetailsLesson(int idLesson) {
        DetailsLesson detailsLesson = new DetailsLesson();

        return detailsLesson.getDetailsLessonsExampleList(idLesson);
    }
}
