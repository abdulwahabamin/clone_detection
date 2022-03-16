    /**
     * Sets up the @half_and_half.xml layout
     */
    private void initUpperHalf() {
    	ImageInfo mInfo = new ImageInfo();
    	mInfo.source = SRC_FIRST_AVAILABLE;
        mInfo.size = SIZE_NORMAL;
    	final ImageView imageView = (ImageView)findViewById(R.id.half_artist_image);
    	String lineOne = "";
    	String lineTwo = "";

        if (ApolloUtils.isArtist(mimeType)) {
        	mChangeButton = (ImageButton)findViewById(R.id.view_more);
        	mChangeButton.setVisibility(View.VISIBLE);
        	mChangeButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                	onToggleButton();
                }
            });
        	String mArtist = getArtist();
            mInfo.type = TYPE_ARTIST;
            mInfo.data = new String[]{ mArtist };  
            lineOne = mArtist;
            lineTwo = MusicUtils.makeAlbumsLabel(this, Integer.parseInt(getNumAlbums()), 0, false);
        }else if (ApolloUtils.isAlbum(mimeType)) {
        	String mAlbum = getAlbum(), mArtist = getArtist();
            mInfo.type = TYPE_ALBUM;
            mInfo.data = new String[]{ getAlbumId(), mAlbum, mArtist };                
            lineOne = mAlbum;
            lineTwo = mArtist;
        } else if (Audio.Playlists.CONTENT_TYPE.equals(mimeType)) {
        	String plyName = bundle.getString(PLAYLIST_NAME);
        	mInfo.type = TYPE_PLAYLIST;
            mInfo.data = new String[]{ plyName };               
            lineOne = plyName;
        }
        else{ 
        	String genName = MusicUtils.parseGenreName(this,
        			MusicUtils.getGenreName(this, bundle.getLong(BaseColumns._ID), true));
        	mInfo.type = TYPE_GENRE;
            mInfo.size = SIZE_NORMAL;
            mInfo.data = new String[]{ genName };             
            lineOne = genName;
        }

        mImageProvider.loadImage( imageView, mInfo );        
        TextView lineOneView = (TextView)findViewById(R.id.half_artist_image_text);
        lineOneView.setText(lineOne);
        TextView lineTwoView = (TextView)findViewById(R.id.half_artist_image_text_line_two);
        lineTwoView.setText(lineTwo);
    }

