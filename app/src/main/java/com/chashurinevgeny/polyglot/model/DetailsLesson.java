package com.chashurinevgeny.polyglot.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chashurin Evgeny on 25.07.2017.
 */

public class DetailsLesson {

    private static List<DetailsLessonsExample> detailsLessonsExampleList;

    public class DetailsLessonsExample {

        private String nameDetails;
        private String descriptionDetails;

        DetailsLessonsExample(String nameDetails, String descriptionDetails) {
            this.nameDetails = nameDetails;
            this.descriptionDetails = descriptionDetails;
        }

        public String getNameDetails() {
            return nameDetails;
        }

        public String getDescriptionDetails() {
            return descriptionDetails;
        }
    }

    List<DetailsLessonsExample> getDetailsLessonsExampleList (int idLesson) {
        switch (idLesson) {
            case 0: {
                detailsLessonsExampleList = new ArrayList<>();
                detailsLessonsExampleList.add(new DetailsLessonsExample("1. Словарь урока","Знакомимся со словами"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("2. Утверждения","Прошедшее, настоящее, будущее"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("3. Отрицания","Прошедшее, настоящее, будущее"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("4. Вопросы","Прошедшее, настоящее, будущее"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("5. Общая тренировка","Все вариации"));
                return detailsLessonsExampleList;
            }
            case 1: {
                detailsLessonsExampleList = new ArrayList<>();
                detailsLessonsExampleList.add(new DetailsLessonsExample("1. Слова на -tion, sion","Как выучить множество слов"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("2. Закрепление урока №1","Тренируем и закрепляем"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("3. Местоимения","Запоминаем местоимения"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("4. Тренировка местоимений","Расширяем возможности"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("5. Вопросительные слова","Запоминаем слова"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("6. Тренировка вопросов","Расширяем возможности"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("7. Предлоги","in, to, from"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("8. Слова паразиты","Тренировка предложений"));
                return detailsLessonsExampleList;
            }
            case 2: {
                detailsLessonsExampleList = new ArrayList<>();
                detailsLessonsExampleList.add(new DetailsLessonsExample("1. Закрепление урока 1 и 2", "Отработка пройденных глаголов"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("2. Утверждения: to be","Прошедшее, настоящее, будущее"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("3. Отрицания: to be","Прошедшее, настоящее, будущее"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("4. Вопросы: to be","Прошедшее, настоящее, будущее"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("5. Процесс","Длительное время"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("6. Глагол + to","I want to/like to"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("7. Чье? -местоимения","Притяжательные местоимения"));
                detailsLessonsExampleList.add(new DetailsLessonsExample("8. Тренировка местоимений","Притяжательные местоимения"));
                return detailsLessonsExampleList;
            }
            default: return detailsLessonsExampleList = new ArrayList<>();
        }
    }
}
