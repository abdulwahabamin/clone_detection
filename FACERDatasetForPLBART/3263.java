    /**
     * This is used when creating the view in XML
     * To have an image load in XML use the tag 'image="http://developer.android.com/images/dialog_buttons.png"'
     * Replacing the url with your desired image
     * Once you have instantiated the XML view you can call
     * setImageDrawable(url) to change the image
     * @param context
     * @param attrSet
     */
    public bGridViewImage(final Context context, final AttributeSet attrSet) {
            super(context, attrSet);
            //final String url = attrSet.getAttributeValue(null, "image");

            instantiate(context);
    }

