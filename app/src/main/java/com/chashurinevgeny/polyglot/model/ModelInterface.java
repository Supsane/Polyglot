package com.chashurinevgeny.polyglot.model;

import java.util.List;

/**
 * Created by Chashurin Evgeny on 16.07.2017.
 */

public interface ModelInterface {
    List<Lessons.LessonExample> retrieveListLessons();
    List<DetailsLesson.DetailsLessonsExample> retrieveDetailsLesson(int idLesson);
}
