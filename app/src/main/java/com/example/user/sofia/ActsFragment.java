package com.example.user.sofia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ActsFragment extends Fragment{

    public ActsFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //Create an ArrayList containing the About and Directions texts
        final ArrayList<Text> texts = new ArrayList<Text>();
        texts.add(new Text(R.string.sofia_theatre_about, R.string.sofia_theatre_get_there, R.drawable.sofia_theatre));
        texts.add(new Text(R.string.sofia_opera_about, R.string.sofia_opera_get_there, R.drawable.sofia_opera_ballet));
        texts.add(new Text(R.string.ndk_about, R.string.ndk_get_there, R.drawable.national_palace_of_culture));
        texts.add(new Text(R.string.odeon_about, R.string.odeon_get_there, R.drawable.odeon_cinema));
        texts.add(new Text(R.string.red_house_about, R.string.red_house_get_there, R.drawable.red_house));

        // Create an {@link TextAdapter}, whose data source is a list of {@link Text}s. The
        // adapter knows how to create list items for each item in the list.
        TextAdapter adapter = new TextAdapter(getActivity(), texts, R.color.category_acts);

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
