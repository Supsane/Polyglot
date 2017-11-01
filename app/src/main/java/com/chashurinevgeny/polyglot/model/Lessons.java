package com.chashurinevgeny.polyglot.model;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.chashurinevgeny.polyglot.DataBase.DataBaseHelper;
import com.chashurinevgeny.polyglot.DataBase.PolyglotApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chashurin Evgeny on 23.07.2017.
 */

public class Lessons {

    private static Lessons lessons;
    private static List<LessonExample> lessonExample;

    private ArrayList<HashMap<String, Object>> listLessons = new ArrayList<>();
    private HashMap<String, Object> lesson;
    private PolyglotApp app = new PolyglotApp();
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;

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
        dataBaseHelper = app.getDataBaseHelper();
        try {
            dataBaseHelper.updateDatabase();
        } catch (SQLException e) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            database = dataBaseHelper.getWritableDatabase();
        } catch (SQLException e) {
            throw e;
        }

        Cursor cursor = database.rawQuery("SELECT * FROM lessons", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            lesson = new HashMap<>();

            lesson.put("name", cursor.getString(1));
            lesson.put("description", cursor.getString(2));

            listLessons.add(lesson);

            cursor.moveToNext();
        }

        cursor.close();

        lessonExample = new ArrayList<>();
        lessonExample.add(new LessonExample("Урок №1", "Базовая таблица глагола. Утверждения, отрицания, вопросы. Личные местоимения"));
        lessonExample.add(new LessonExample("Урок №2", "Как знать тысячи слов. Местоимения, вопросительные слова, предлоги to, in, from"));
        lessonExample.add(new LessonExample("Урок №3", "Глагол to be. Действия в процессе. Притяжательные местоимения"));
        lessonExample.add(new LessonExample("Урок №4", "Рассказ о себе. Разговорные фразы приветствия и прощания"));
        lessonExample.add(new LessonExample("Урок №5", "Прилагательные. Степени сравнения. Параметры времени"));
        lessonExample.add(new LessonExample("Урок №6", "Much/many. Неопределенные местоимения. Параметры времени"));
        lessonExample.add(new LessonExample("Урок №7", "Предложения с Let's. Новые глаголы и фразы"));
        lessonExample.add(new LessonExample("Урок №8", "Система предлогов. Использование глаголов с предлогами"));
        lessonExample.add(new LessonExample("Урок №9", "Новые глаголы. Возвратные местоимения. Частные слова"));
        lessonExample.add(new LessonExample("Урок №10", "Новые слова и словосочетания. Глаголы: support, learn, cook, reserve, fly"));
        lessonExample.add(new LessonExample("Урок №11", "Ключи: факт, процесс, результат. Чувственные состояния. О погоде"));
        lessonExample.add(new LessonExample("Урок №12", "Разговорные фразы о путешествиях. Порядковые числительные"));
        lessonExample.add(new LessonExample("Урок №13", "Союз \"чтобы\". Призыв к действию. Предложения с can и should. Тренировка новых глаголов"));
        lessonExample.add(new LessonExample("Урок №14", "Фразы по телефону. Условные предложения. Вопросы к подлежащему"));
        lessonExample.add(new LessonExample("Урок №15", "Новые глаголы, слова и фразы"));
        lessonExample.add(new LessonExample("Урок №16", "Страдательный залог. Новые слова и фразы"));
    }

    static List<LessonExample> getLessonExample() {
        if (lessons == null) {
            lessons = new Lessons();
        }
        return lessonExample;
    }
}
