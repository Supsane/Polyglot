package com.chashurinevgeny.polyglot.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chashurinevgeny.polyglot.R;
import com.chashurinevgeny.polyglot.model.DetailsLesson;
import com.chashurinevgeny.polyglot.model.Lessons;
import com.chashurinevgeny.polyglot.model.ModelImpl;
import com.chashurinevgeny.polyglot.model.ModelInterface;
import com.chashurinevgeny.polyglot.presenter.PresenterImpl;
import com.chashurinevgeny.polyglot.presenter.PresenterInterface;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsLessonFragment extends Fragment implements ViewInterface {

    private DetailsLessonRecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private int idLesson;

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }

    public DetailsLessonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_lesson, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            ModelInterface model = new ModelImpl();
            PresenterInterface presenter = new PresenterImpl(model);
            presenter.loadDetailsLesson(this, idLesson);

            recyclerView = (RecyclerView) view.findViewById(R.id.listDetailsLesson);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void displayListLessons(List<Lessons.LessonExample> lessonExample) {

    }

    @Override
    public void displayDetailsLesson(List<DetailsLesson.DetailsLessonsExample> detailsLessonsExamples) {
        adapter = new DetailsLessonRecyclerAdapter(detailsLessonsExamples);
    }
}
