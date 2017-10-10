package com.chashurinevgeny.polyglot.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chashurinevgeny.polyglot.R;
import com.chashurinevgeny.polyglot.model.Lessons;

import java.util.List;

/**
 * Created by Chashurin Evgeny on 23.07.2017.
 */

public class ListLessonsRecyclerAdapter extends RecyclerView.Adapter<ListLessonsRecyclerAdapter.LessonHolder> {

    private final List<Lessons.LessonExample> lessonExample;

    public ListLessonsRecyclerAdapter(List<Lessons.LessonExample> lessonExample) {
        this.lessonExample = lessonExample;
    }

    @Override
    public LessonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_lesson, parent, false);
        return new LessonHolder(view);
    }

    @Override
    public void onBindViewHolder(LessonHolder holder, int position) {
        holder.bindCrime(lessonExample.get(position));
    }

    @Override
    public int getItemCount() {
        return lessonExample.size();
    }

    class LessonHolder extends RecyclerView.ViewHolder {

        private TextView nameLesson;
        private TextView descriptionLesson;

        LessonHolder(View itemView) {
            super(itemView);
            nameLesson = (TextView) itemView.findViewById(R.id.nameLesson);
            descriptionLesson = (TextView) itemView.findViewById(R.id.descriptionLesson);
        }

        void bindCrime(Lessons.LessonExample lessonExample) {
            nameLesson.setText(lessonExample.getNameLesson());
            descriptionLesson.setText(lessonExample.getDescriptionLesson());
        }
    }
}
