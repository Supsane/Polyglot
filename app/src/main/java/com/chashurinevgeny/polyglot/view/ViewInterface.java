package com.chashurinevgeny.polyglot.view;

import com.chashurinevgeny.polyglot.model.Lessons;

import java.util.List;

/**
 * Created by Chashurin Evgeny on 16.07.2017.
 */

public interface ViewInterface {
    void displayInfo(List<Lessons.LessonExample> lessonExample);
}
