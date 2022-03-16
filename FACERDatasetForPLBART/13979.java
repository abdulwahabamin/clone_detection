    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == Activity.RESULT_OK && requestCode == RESULT_LOAD_IMAGE  && data != null)
	    {
        	Uri selectedImage = data.getData();
	        String[] filePathColumn = { MediaStore.Images.Media.DATA };
	        Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
	        cursor.moveToFirst();
	        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	        String picturePath = cursor.getString(columnIndex);
	        cursor.close();
        	
            ImageInfo mInfo = new ImageInfo();
	        if (Audio.Artists.CONTENT_TYPE.equals(mimeType)) { 
	            mInfo.type = TYPE_ARTIST;
	            mInfo.data = new String[]{ getArtist(), picturePath };    
	        } else if (Audio.Albums.CONTENT_TYPE.equals(mimeType)) {
	            mInfo.type = TYPE_ALBUM;
	            mInfo.data = new String[]{ getAlbumId(), getAlbum(), getArtist(), picturePath };
	        } else if (Audio.Playlists.CONTENT_TYPE.equals(mimeType)) {
	            mInfo.type = TYPE_PLAYLIST;
	            mInfo.data = new String[]{ bundle.getString(PLAYLIST_NAME), picturePath };
	        }
	        else{ 
	        	Long id = bundle.getLong(BaseColumns._ID);
	            mInfo.type = TYPE_GENRE;
	            mInfo.data = new String[]{  MusicUtils.parseGenreName(this, MusicUtils.getGenreName(this, id, true)), picturePath };
	        }
	        
            mInfo.size = SIZE_NORMAL;
            mInfo.source = SRC_GALLERY;          
            mImageProvider.loadImage((ImageView)findViewById(R.id.half_artist_image), mInfo );
	        
	    }
    }

