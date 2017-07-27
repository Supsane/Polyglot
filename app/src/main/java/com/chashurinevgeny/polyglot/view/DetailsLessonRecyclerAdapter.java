package com.chashurinevgeny.polyglot.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chashurinevgeny.polyglot.R;
import com.chashurinevgeny.polyglot.model.DetailsLesson;

import java.util.List;

/**
 * Created by Chashurin Evgeny on 27.07.2017.
 */

class DetailsLessonRecyclerAdapter extends RecyclerView.Adapter<DetailsLessonRecyclerAdapter.DetailsHolder> {

    private final List<DetailsLesson.DetailsLessonsExample> detailsLessonsExamples;

    public DetailsLessonRecyclerAdapter(List<DetailsLesson.DetailsLessonsExample> detailsLessonsExamples) {
        this.detailsLessonsExamples = detailsLessonsExamples;
    }

    @Override
    public DetailsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_lesson, parent, false);
        return new DetailsHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailsHolder holder, int position) {
        holder.bindCrime(detailsLessonsExamples.get(position));
    }

    @Override
    public int getItemCount() {
        return detailsLessonsExamples.size();
    }

    static class DetailsHolder extends RecyclerView.ViewHolder {

        private TextView nameDetails;
        private TextView descriptionDetails;

        DetailsHolder(View itemView) {
            super(itemView);
            nameDetails = (TextView) itemView.findViewById(R.id.nameLesson);
            descriptionDetails = (TextView) itemView.findViewById(R.id.descriptionLesson);
        }

        void bindCrime(DetailsLesson.DetailsLessonsExample detailsLessonsExample) {
            nameDetails.setText(detailsLessonsExample.getNameDetails());
            descriptionDetails.setText(detailsLessonsExample.getDescriptionDetails());
        }
    }
}
