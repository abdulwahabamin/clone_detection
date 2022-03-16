	private void populateSongs(String artistName, String albumDirName, String albumPath, String artistAbsDirName){
		
		songs = new ArrayList<Map<String,String>>();
		
		File artistDir = new File(artistAbsDirName);
		if(albumDirName != null && albumPath != null){
			albumDir = new File(albumPath);
			if(!albumDir.exists()) {
				albumDir = new File(artistDir, albumDirName);
			}
		} else {
			albumDir = artistDir; 
		}

		SharedPreferences prefs = getSharedPreferences("PrettyGoodMusicPlayer", MODE_PRIVATE);
		resume = prefs.getString(albumDir.getAbsolutePath(), null);
		if(resume != null){
			Log.i(TAG, "Found resumable time! " + resume);
		} else {
			Log.i(TAG, "Didn't find a resumable time");
		}
		Log.i(TAG, "Artist dir: " + artistDir);
		Log.i(TAG, "Album dir: " + albumDir);

		List<File> songFiles = new ArrayList<File>();

		// Did the user provide an exact path to the album?
		if(albumDir.exists() && albumDir.isDirectory() && (albumDir.listFiles() != null)){
			Log.d(TAG, "external storage directory = " + albumDir);
			
			for(File song : Utils.getAllSongsInDirRecursive(albumDir)){
				if(Utils.isValidSongFile(song)){
					songFiles.add(song);
				} else {
					Log.v(TAG, "Found invalid song file " + song);
				}
			}
			
			// We assume that song files start with XX where XX is a number indicating the songs location within an album. 
			Collections.sort(songFiles, Utils.songFileComparator);
			// Did the user provide an artist, but no album?
		} else if(artistDir.exists() && artistDir.listFiles() != null) {
			for (File f : artistDir.listFiles()) {
				if (f.isDirectory()) {
					List<File> songs = Utils.getAllSongsInDirRecursive(f);
					songFiles.addAll(songs);
				} else if (Utils.isValidSongFile(f)) {
					songFiles.add(f);
				}
			}
			// Did the user pick an album from 'All'?
		}else if(albumDir.exists() && albumDir.isDirectory() && albumDir.listFiles() != null){
			List<File> songs = Utils.getAllSongsInDirRecursive(albumDir);
			songFiles.addAll(songs);
		} else {
			// If the album didn't exist, just list all of the songs we can find.
			Log.d(TAG, "Adding all songs...");
			File bestGuessMusicDir = Utils.getBestGuessMusicDirectory();
			String prefDir = prefs.getString("ARTIST_DIRECTORY", bestGuessMusicDir.getAbsolutePath());
			File baseDir = new File(prefDir);
			List<File> albums = Utils.getAllAlbumsInDirRecursive(baseDir);

			Collections.sort(albums, Utils.albumFileComparator);
			
			for(File albumFile : albums){
				if(Utils.isValidAlbumDirectory(albumFile)){
					// get the songs in the album, sort them, then
					// add them to the list
					List<File> songFilesInAlbum = Utils.getAllSongsInDirRecursive(albumFile);

					List<File> songFilesInAlbumList = new ArrayList<File>();
					for(File songFile : songFilesInAlbum){
						if(Utils.isValidSongFile(songFile)){
							songFilesInAlbumList.add(songFile);
						}
					}
					Collections.sort(songFilesInAlbumList, Utils.songFileComparator);
					songFiles.addAll(songFilesInAlbumList);
				}
			}
		}
		
		for(File song : songFiles){
			Log.v(TAG, "Adding song " + song);
			Map<String,String> map = new HashMap<String, String>();
			map.put("song", Utils.getPrettySongName(song));			
			songs.add(map);
		}
		
		// If there is a value set to resume to, and audiobook mode is enabled
		// add an option to start where they left off
		if(resume != null && audiobookMode){
			try{
				String resumeSongName = resume.substring(0, resume.lastIndexOf('~'));
				
				File resumeFile = new File(albumDir, resumeSongName);
				if(resumeFile.exists()){
					String progress = resume.substring(resume.lastIndexOf('~') + 1);
					int prog = Integer.valueOf(progress);
					resumeProgress = prog;
					resumeSongName = Utils.getPrettySongName(resumeSongName);
					int minutes = prog / (1000 * 60);
					int seconds = (prog % (1000 * 60)) / 1000;
					String time = String.format(Locale.getDefault(), "%d:%02d", minutes, seconds);
					Map<String, String> map = new HashMap<String, String>();
					map.put("song", getResources().getString(R.string.resume) + ": " + resumeSongName + " (" + time + ")");
					songs.add(0, map);
					// loop over the available songs, make sure we still have it
					for(int i = 0; i< songFiles.size(); i++){
						File song = songFiles.get(i);
						if(song.equals(resumeFile)){
							resumeFilePos  = i;
							break;
						}
					}
					if(resumeFilePos >= 0){
						hasResume = true;
					}
				} else {
					Log.w(TAG, "Couldn't find file to resume");
				}
			} catch (Exception e){
				Log.w(TAG, "Couldn't add resume song name", e);
				hasResume = false;
			}
		}
		
		songAbsFileNameList = new ArrayList<String>();
		for(File song : songFiles){
			songAbsFileNameList.add(song.getAbsolutePath());
		}
	}

