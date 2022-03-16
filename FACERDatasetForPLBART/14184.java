    /**
     * Header used in the track browser
     * 
     * @param fragment
     * @param view
     * @param string
     */
    public static void listHeader(Fragment fragment, View view, String string) {
        if (fragment.getArguments() != null) {
            TextView mHeader = (TextView)view.findViewById(R.id.title);
            String mimetype = fragment.getArguments().getString(MIME_TYPE);
            if (Audio.Artists.CONTENT_TYPE.equals(mimetype)) {
                mHeader.setVisibility(View.VISIBLE);
                mHeader.setText(string);
            } else if (Audio.Albums.CONTENT_TYPE.equals(mimetype)) {
                mHeader.setVisibility(View.VISIBLE);
                mHeader.setText(string);
            }
        }
    }

