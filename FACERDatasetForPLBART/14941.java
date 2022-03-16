    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    	if (Audio.Artists.CONTENT_TYPE.equals(mimeType)) {
    		
        	menu.setHeaderTitle(R.string.image_edit_artists);
        	getMenuInflater().inflate(R.menu.context_artistimage, menu); 
        	
        } else if (Audio.Albums.CONTENT_TYPE.equals(mimeType)) {
        	
        	menu.setHeaderTitle(R.string.image_edit_albums);
        	getMenuInflater().inflate(R.menu.context_albumimage, menu); 
        	
        } else if (Audio.Playlists.CONTENT_TYPE.equals(mimeType)) {        	
        	menu.setHeaderTitle(R.string.image_edit_playlist);
        	getMenuInflater().inflate(R.menu.context_playlist_genreimage, menu);         	
        }
        else{        	
        	menu.setHeaderTitle(R.string.image_edit_genre);
        	getMenuInflater().inflate(R.menu.context_playlist_genreimage, menu);        	
        }
    }

