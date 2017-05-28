package com.example.user.sofia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class GreensFragment extends Fragment{

    public GreensFragment(){
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //Create an ArrayList containing the About and Directions texts
        final ArrayList<Text> texts = new ArrayList<Text>();
        texts.add(new Text(R.string.borisova_about, R.string.borisova_get_there, R.drawable.borisova_gradina));
        texts.add(new Text(R.string.botanical_about, R.string.botanical_get_there, R.drawable.university_botanical_garden));
        texts.add(new Text(R.string.south_park_about, R.string.south_park_get_there, R.drawable.south_park));
        texts.add(new Text(R.string.vitosha_about, R.string.vitosha_get_there, R.drawable.vitosha_national_park));
        texts.add(new Text(R.string.loven_about, R.string.loven_get_there, R.drawable.loven_park));

        // Create an {@link TextAdapter}, whose data source is a list of {@link Text}s. The
        // adapter knows how to create list items for each item in the list.
        TextAdapter adapter = new TextAdapter(getActivity(), texts, R.color.category_greens);

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
