package com.example.user.sofia;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link TextAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Text} objects.
 */
public class TextAdapter extends ArrayAdapter<Text>  {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link TextAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param texts is the list of {@link Text}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public TextAdapter(Context context, ArrayList<Text> texts, int colorResourceId) {
        super(context, 0, texts);
        mColorResourceId = colorResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Text} object located at this position in the list
        Text currentText = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID about_text_view.
        TextView aboutTextView = (TextView) listItemView.findViewById(R.id.about_text_view);
        // Get the About text from the currentText object and set this text on
        // the About TextView.
        aboutTextView.setText(currentText.getGuideTextId());

        // Find the TextView in the list_item.xml layout with the ID directions_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.directions_text_view);
        // Get the Directions text from the currentText object and set this text on
        // the Directions TextView.
        defaultTextView.setText(currentText.getDirectionsTextId());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this text or not
        if (currentText.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentText.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}

