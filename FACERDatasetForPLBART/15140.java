	/**
     * @return A custom ContextMenu header
     */
    public static  View setHeaderLayout(String Type, Cursor cursor, Activity activity) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View header = inflater.inflate(R.layout.context_menu_header, null, false);

        // Artist image
        final ImageView mHanderImage = (ImageView)header.findViewById(R.id.header_image);
        String albumId="",artistName="",albumName="";

        if(Type == TYPE_ALBUM){
            albumName = cursor.getString(cursor.getColumnIndexOrThrow(AlbumColumns.ALBUM));
            artistName = cursor.getString(cursor.getColumnIndexOrThrow(AlbumColumns.ARTIST));
            albumId = cursor.getString(cursor.getColumnIndexOrThrow(BaseColumns._ID));
        }
        else{
            artistName = cursor.getString(cursor.getColumnIndexOrThrow(ArtistColumns.ARTIST));
        }
        
        
        ImageInfo mInfo = new ImageInfo();
        mInfo.type = Type;
        mInfo.size = SIZE_THUMB;
        mInfo.source = SRC_FIRST_AVAILABLE;
        mInfo.data = (Type == TYPE_ALBUM ? new String[]{ albumId , artistName, albumName } : new String[]{ artistName});
       
        ImageProvider.getInstance(activity).loadImage( mHanderImage, mInfo );

        // Set artist name
        TextView headerText = (TextView)header.findViewById(R.id.header_text);
        headerText.setText( (Type == TYPE_ALBUM ? albumName : artistName));
        headerText.setBackgroundColor((activity).getResources().getColor(R.color.transparent_black));
        return header;
    }

