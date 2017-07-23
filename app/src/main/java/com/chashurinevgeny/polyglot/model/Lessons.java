package com.chashurinevgeny.polyglot.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chashurin Evgeny on 23.07.2017.
 */

public class Lessons {

    private static Lessons lessons;
    private static List<LessonExample> lessonExample;

    public class LessonExample {
        private String nameLesson;
        private String descriptionLesson;

        LessonExample(String nameLesson, String descriptionLesson) {
            this.nameLesson = nameLesson;
            this.descriptionLesson = descriptionLesson;
        }

        public String getNameLesson() {
            return nameLesson;
        }

        public String getDescriptionLesson() {
            return descriptionLesson;
        }

    }

    private Lessons() {
        lessonExample = new ArrayList<>(16);
        lessonExample.add(new LessonExample("Урок №1", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №2", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №3", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №4", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №5", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №6", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №7", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №8", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №9", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №10", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №11", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №12", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №13", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №14", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №15", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
        lessonExample.add(new LessonExample("Урок №16", "Базовая таблица глагола. Утверждени, отрицания, вопосы. Личные местоимения."));
    }

    static List<LessonExample> getLessonExample() {
        if(lessons == null) {
            lessons = new Lessons();
        }
        return lessonExample;
    }
}
