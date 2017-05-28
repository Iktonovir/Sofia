package com.example.user.sofia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class SpeaksFragment extends Fragment {

    public SpeaksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //Create an ArrayList containing the English and Bulgarian texts
        final ArrayList<Text> texts = new ArrayList<Text>();
        texts.add(new Text(R.string.greeting_hello, R.string.greeting_bulgarian_hello));
        texts.add(new Text(R.string.phrase_how_are_you, R.string.phrase_bulgarian_how_are_you));
        texts.add(new Text(R.string.phrase_how_much, R.string.phrase_bulgarian_how_much));
        texts.add(new Text(R.string.phrase_i_need_help, R.string.phrase_bulgarian_i_need_help));
        texts.add(new Text(R.string.phrase_i_need_free_wifi, R.string.phrase_bulgarian_i_need_free_wifi));

        // Create an {@link TextAdapter}, whose data source is a list of {@link Text}s. The
        // adapter knows how to create list items for each item in the list.
        TextAdapter adapter = new TextAdapter(getActivity(), texts, R.color.category_speaks);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link TextAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Text} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }

}
