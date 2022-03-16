    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	ImageInfo mInfo = null;      
        switch (item.getItemId()) {
            case R.id.image_edit_gallery:
            	Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            	startActivityForResult(i, RESULT_LOAD_IMAGE);
            	return true;
            case R.id.image_edit_file:            	
                mInfo = new ImageInfo();
                mInfo.type = TYPE_ALBUM;
                mInfo.size = SIZE_NORMAL;
                mInfo.source = SRC_FILE;
                mInfo.data = new String[]{ getAlbumId(), getArtist(), getAlbum() };                
                mImageProvider.loadImage((ImageView)findViewById(R.id.half_artist_image), mInfo );
                return true;
            case R.id.image_edit_lastfm:           	
                mInfo = new ImageInfo();
                mInfo.size = SIZE_NORMAL;
                mInfo.source = SRC_LASTFM;                
    	        if (Audio.Artists.CONTENT_TYPE.equals(mimeType)) { 
                    mInfo.type = TYPE_ARTIST;
                    mInfo.data = new String[]{ getArtist() };
    	        } else if (Audio.Albums.CONTENT_TYPE.equals(mimeType)) {
                    mInfo.type = TYPE_ALBUM;
                    mInfo.data = new String[]{ getAlbumId(), getArtist(), getAlbum() };
    	        } 
                mImageProvider.loadImage((ImageView)findViewById(R.id.half_artist_image), mInfo );
                return true;
            case R.id.image_edit_web:
            	onSearchWeb();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

