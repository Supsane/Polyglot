package com.chashurinevgeny.polyglot.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chashurinevgeny.polyglot.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GrammarReferenceFragment extends Fragment {

    private int idLesson;

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }

    public GrammarReferenceFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        switch (idLesson) {
            case 0: {
                return inflater.inflate(R.layout.fragment_gram_ref_lesson_1, container, false);
            }
            case 1: {
                return inflater.inflate(R.layout.fragment_gram_ref_lesson_2, container, false);
            }
            case 2: {
                return inflater.inflate(R.layout.fragment_gram_ref_lesson_3, container, false);
            }
            default: return inflater.inflate(R.layout.fragment_gram_ref_lesson_1, container, false);
        }
    }

}
