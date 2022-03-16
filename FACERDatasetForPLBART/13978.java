    public void onSearchWeb(){
    	String query = "";
    	if (Audio.Artists.CONTENT_TYPE.equals(mimeType)) {
    		query = getArtist();
        } else if (Audio.Albums.CONTENT_TYPE.equals(mimeType)) {
        	query = getAlbum() + " " + getArtist();
        } else if (Audio.Playlists.CONTENT_TYPE.equals(mimeType)) {
        	query = bundle.getString(PLAYLIST_NAME);
        }
        else{
            Long id = bundle.getLong(BaseColumns._ID);
            query = MusicUtils.parseGenreName(this, MusicUtils.getGenreName(this, id, true));
        }
        final Intent googleSearch = new Intent(Intent.ACTION_WEB_SEARCH);
        googleSearch.putExtra(SearchManager.QUERY, query);
        startActivity(googleSearch);	
    }

