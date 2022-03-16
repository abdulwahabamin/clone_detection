    /**
     * @return A custom ContextMenu header
     */
    public View setHeaderLayout() {
        // Get album name
        String albumName = mCursor.getString(mAlbumNameIndex);
        // Get artist name
        String artistName = mCursor.getString(mArtistNameIndex);
        // Get albumId
        String albumId = mCursor.getString(mAlbumIdIndex);

        // Inflate the header View
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View header = inflater.inflate(R.layout.context_menu_header, null, false);

        // Artist image
        ImageView headerImage = (ImageView)header.findViewById(R.id.header_image);
        
        ImageInfo mInfo = new ImageInfo();
        mInfo.type = TYPE_ALBUM;
        mInfo.size = SIZE_THUMB;
        mInfo.source = SRC_FIRST_AVAILABLE;
        mInfo.data = new String[]{ albumId , artistName, albumName };
        
        ImageProvider.getInstance( getActivity() ).loadImage( headerImage, mInfo );
        
        // Set artist name
        TextView headerText = (TextView)header.findViewById(R.id.header_text);
        headerText.setText(albumName);
        headerText.setBackgroundColor(getResources().getColor(R.color.transparent_black));
        return header;
    }

