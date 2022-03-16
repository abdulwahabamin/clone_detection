    /**
     * @return A custom ContextMenu header
     */
    public View setHeaderLayout() {
        // Get artist name
        final String artistName = mCursor.getString(mArtistNameIndex);

        // Inflate the header View
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View header = inflater.inflate(R.layout.context_menu_header, null, false);

        // Artist image
        final ImageView mHanderImage = (ImageView)header.findViewById(R.id.header_image);
        
        ImageInfo mInfo = new ImageInfo();
        mInfo.type = TYPE_ARTIST;
        mInfo.size = SIZE_THUMB;
        mInfo.source = SRC_FIRST_AVAILABLE;
        mInfo.data = new String[]{ artistName};
        
        ImageProvider.getInstance(getActivity()).loadImage( mHanderImage, mInfo );

        // Set artist name
        TextView headerText = (TextView)header.findViewById(R.id.header_text);
        headerText.setText(artistName);
        headerText.setBackgroundColor(getResources().getColor(R.color.transparent_black));
        return header;
    }

