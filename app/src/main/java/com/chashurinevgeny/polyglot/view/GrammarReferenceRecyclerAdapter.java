package com.chashurinevgeny.polyglot.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chashurinevgeny.polyglot.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chashurin Evgeny on 13.08.2017.
 */

class GrammarReferenceRecyclerAdapter extends RecyclerView.Adapter<GrammarReferenceRecyclerAdapter.GrammarRefHolder> {

    private final List<GrammarReference.GrammarReferenceExample> grammarReferenceExamples;

    GrammarReferenceRecyclerAdapter(Context context) {
        GrammarReference grammarReference = new GrammarReference(context);
        grammarReferenceExamples = grammarReference.getGrammarReferenceExampleList(context);
    }

    @Override
    public GrammarRefHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grammar_ref_item, parent, false);
        return new GrammarRefHolder(view);
    }

    @Override
    public void onBindViewHolder(GrammarRefHolder holder, int position) {
        holder.bindCrime(grammarReferenceExamples.get(position));
    }

    @Override
    public int getItemCount() {
        return grammarReferenceExamples.size();
    }

    class GrammarRefHolder extends RecyclerView.ViewHolder {

        private TextView nameGramRef;
        private TextView descriptionGramRef;

        GrammarRefHolder(View itemView) {
            super(itemView);
            nameGramRef = (TextView) itemView.findViewById(R.id.nameGramRef);
            descriptionGramRef = (TextView) itemView.findViewById(R.id.descriptionGramRef);
        }

        void bindCrime(GrammarReference.GrammarReferenceExample grammarReferenceExample) {
            nameGramRef.setText(grammarReferenceExample.getNameGramRef());
            descriptionGramRef.setText(grammarReferenceExample.getDescriptionGramRef());
        }
    }

    private class GrammarReference {

        private GrammarReference grammarReference;
        private List<GrammarReferenceExample> grammarReferenceExampleList;

        class GrammarReferenceExample {
            private String nameGramRef;
            private String descriptionGramRef;

            GrammarReferenceExample(Context context) {
                nameGramRef = context.getResources().getString(R.string.summary);
                descriptionGramRef = context.getResources().getString(R.string.grammar_ref);
            }

            String getNameGramRef() {
                return nameGramRef;
            }

            String getDescriptionGramRef() {
                return descriptionGramRef;
            }
        }

        GrammarReference(Context context) {
            grammarReferenceExampleList = new ArrayList<>();
            grammarReferenceExampleList.add(new GrammarReferenceExample(context));
        }

        List<GrammarReferenceExample> getGrammarReferenceExampleList(Context context) {
            if (grammarReference == null) {
                grammarReference = new GrammarReference(context);
            }
            return grammarReferenceExampleList;
        }
    }
}
