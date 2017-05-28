package com.example.user.sofia;

public class Text {

    /** String resource ID for the about text */
    private int mGuideTextId;

    /** String resource ID for the directions text */
    private int mDirectionsTextId;

    /** Image resource ID for the place */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for Speaks section */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Text object.
     *
     * @param guideTextId is the string resource ID for the the about text
     * @param directionsTextId is the string resource ID for the directions text
     */

    public Text(int guideTextId, int directionsTextId) {
        mGuideTextId = guideTextId;
        mDirectionsTextId = directionsTextId;
    }

    /**
     * Create a new Text object.
     *
     * @param guideTextId is the string resource ID for the About text
     * @param directionsTextId is the string resource ID for the Directions text
     * @param imageResourceId is the image resource ID for the place
     */
    public Text(int guideTextId, int directionsTextId,int imageResourceId) {
        mGuideTextId = guideTextId;
        mDirectionsTextId = directionsTextId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the string resource ID for text.
     */
    public int getGuideTextId() {
        return mGuideTextId;
    }

    public int getDirectionsTextId() {
        return mDirectionsTextId;
    }
    /**
     * Get the image resource ID of the place.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
