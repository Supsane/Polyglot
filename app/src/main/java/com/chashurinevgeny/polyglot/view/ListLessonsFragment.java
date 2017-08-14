package com.chashurinevgeny.polyglot.view;


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

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListLessonsFragment extends Fragment implements ViewInterface {

    private ListLessonsRecyclerAdapter adapter;
    private RecyclerView listLessons;

    public ListLessonsFragment() {
        // Required empty public constructor
    }

    interface ListLessonListener {
        void listLessonItemClicked(int id);
    }

    private ListLessonListener listLessonListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_lessons, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            ModelInterface model = new ModelImpl();
            PresenterInterface presenter = new PresenterImpl(model);
            presenter.loadListLessons(this);

            listLessons = (RecyclerView) view.findViewById(R.id.listLessons);
            listLessons.setLayoutManager(new LinearLayoutManager(view.getContext()));
            listLessons.setHasFixedSize(true);
            listLessons.setAdapter(adapter);
            listLessons.addOnItemTouchListener(
                    new RecyclerItemClickListener(view.getContext(), listLessons, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            if (listLessonListener != null) {
                                listLessonListener.listLessonItemClicked(position);
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
        listLessonListener = (ListLessonListener) context;
    }

    @Override
    public void displayListLessons(List<Lessons.LessonExample> lessonExample) {
        adapter = new ListLessonsRecyclerAdapter(lessonExample);
    }

    @Override
    public void displayDetailsLesson(List<DetailsLesson.DetailsLessonsExample> detailsLessonsExamples) {

    }
}
