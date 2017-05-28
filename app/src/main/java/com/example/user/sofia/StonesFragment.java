package com.example.user.sofia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class StonesFragment extends Fragment {

    public StonesFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //Create an ArrayList containing the About and Directions texts
        final ArrayList<Text> texts = new ArrayList<Text>();
        texts.add(new Text(R.string.church_petka_about, R.string.church_petka_get_there, R.drawable.church_petka));
        texts.add(new Text(R.string.synagogue_about, R.string.synagogue_get_there, R.drawable.sofia_synagogue));
        texts.add(new Text(R.string.mosque_about, R.string.mosque_get_there, R.drawable.banya_bashi_mosque));
        texts.add(new Text(R.string.bells_about, R.string.bells_get_there, R.drawable.the_bells));
        texts.add(new Text(R.string.ministry_about, R.string.ministry_get_there, R.drawable.ministry_agriculture_forestry));

        // Create an {@link TextAdapter}, whose data source is a list of {@link Text}s. The
        // adapter knows how to create list items for each item in the list.
        TextAdapter adapter = new TextAdapter(getActivity(), texts, R.color.category_stones);

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
