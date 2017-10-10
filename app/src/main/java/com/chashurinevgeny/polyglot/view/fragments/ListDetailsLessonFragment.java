package com.chashurinevgeny.polyglot.view.fragments;


import android.content.Context;
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
import com.chashurinevgeny.polyglot.view.adapters.*;
import com.chashurinevgeny.polyglot.view.RecyclerItemClickListener;
import com.chashurinevgeny.polyglot.view.ViewInterface;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListDetailsLessonFragment extends Fragment implements ViewInterface {

    private final String IDLESSON = "idLesson";
    private ListDetailsLessonRecyclerAdapter listDetailsLessonRecyclerAdapter;
    private GrammarReferenceRecyclerAdapter grammarReferenceRecyclerAdapter;
    private RecyclerView listDetailsLesson;
    private RecyclerView listGrammarReference;
    private int idLesson;

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }

    public interface DetailsLessonListener {
        void detailsLessonItemClicked(int id);

        void grammarReferenceItemClicked(int idLesson);
    }

    private DetailsLessonListener detailsLessonListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            idLesson = savedInstanceState.getInt(IDLESSON);
        }
        return inflater.inflate(R.layout.fragment_details_lesson, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            ModelInterface model = new ModelImpl();
            PresenterInterface presenter = new PresenterImpl(model);
            presenter.loadListDetailsLesson(this, idLesson);

            listDetailsLesson = (RecyclerView) view.findViewById(R.id.listDetailsLesson);
            listDetailsLesson.setLayoutManager(new LinearLayoutManager(view.getContext()));
            listDetailsLesson.setHasFixedSize(true);
            listDetailsLesson.setAdapter(listDetailsLessonRecyclerAdapter);
            listDetailsLesson.addOnItemTouchListener(
                    new RecyclerItemClickListener(view.getContext(), listDetailsLesson, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            if (detailsLessonListener != null) {
                                detailsLessonListener.detailsLessonItemClicked(position);
                            }
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            listGrammarReference = (RecyclerView) view.findViewById(R.id.grammarRefList);
            listGrammarReference.setLayoutManager(new LinearLayoutManager(view.getContext()));
            listGrammarReference.setHasFixedSize(true);
            listGrammarReference.setAdapter(grammarReferenceRecyclerAdapter);
            listGrammarReference.addOnItemTouchListener(
                    new RecyclerItemClickListener(view.getContext(), listGrammarReference, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            if (detailsLessonListener != null) {
                                detailsLessonListener.grammarReferenceItemClicked(idLesson);
                            }
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        detailsLessonListener = (DetailsLessonListener) context;
    }

    @Override
    public void displayListLessons(List<Lessons.LessonExample> lessonExample) {

    }

    @Override
    public void displayListDetailsLesson(List<DetailsLesson.DetailsLessonsExample> detailsLessonsExamples) {
        listDetailsLessonRecyclerAdapter = new ListDetailsLessonRecyclerAdapter(detailsLessonsExamples);
        grammarReferenceRecyclerAdapter = new GrammarReferenceRecyclerAdapter(getContext());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(IDLESSON, idLesson);
    }
}
