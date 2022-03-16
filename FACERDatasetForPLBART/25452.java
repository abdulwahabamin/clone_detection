	/**
	 *
	 * @param artistName
	 * @param artistPath
	 */
	private void populateAlbums(String artistName, String artistPath){
		albums = new ArrayList<Map<String,String>>();
		
		File artist = new File(artistPath);
		Log.d(TAG, "storage directory = " + artist);

		if(!artist.isDirectory() || (artist.listFiles() == null)){
			Log.i(TAG, "Non-directory artist provided: " +  artistPath);
			// Assume they meant to use all albums.
            SharedPreferences prefs = getSharedPreferences("PrettyGoodMusicPlayer", MODE_PRIVATE);
            File bestGuessMusicDir = Utils.getBestGuessMusicDirectory();
            String prefDir = prefs.getString("ARTIST_DIRECTORY", bestGuessMusicDir.getAbsolutePath());
            File baseDir = new File(prefDir);
            albumFiles = Utils.getAllAlbumsInDirRecursive(baseDir);
		} else {
            albumFiles = new ArrayList<File>();
            for(File albumFile : artist.listFiles()){
                if(Utils.isValidAlbumDirectory(albumFile)){
                    albumFiles.add(albumFile);
                } else {
                    Log.v(TAG, "Found invalid album " + albumFile);
                }
            }
        }

		Collections.sort(albumFiles, new Comparator<File>(){

			@Override
			public int compare(File lhs, File rhs) {
				return lhs.getName().compareTo(rhs.getName());
			}
			
		});
		
		albumFiles.add(0,new File("All"));
		
		for(File albumFile : albumFiles){
			String album = albumFile.getName();
			Log.v(TAG, "Adding album " + album);
			Map<String,String> map = new HashMap<String, String>();
			map.put("album", album);			
			albums.add(map);
		}
		
		// If albums size is 1, then there were no directories in this folder.
		// skip straight to listing songs.
		if(albums.size() == 1){
       	 Intent intent = new Intent(AlbumList.this, SongList.class);
		 intent.putExtra(ALBUM_NAME, "All");
		 intent.putExtra(ALBUM_PATH, "All");
       	 intent.putExtra(ArtistList.ARTIST_NAME, artist.getName());
       	 intent.putExtra(ArtistList.ARTIST_ABS_PATH_NAME, artistPath);
       	 startActivity(intent);
       	 // In this case we don't want to add the AlbumList to the back stack
       	 // so call 'finish' immediately.
       	 finish();
		}
	}

