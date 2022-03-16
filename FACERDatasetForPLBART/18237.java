    /****************************************************************************************
     * Scans the entire Music Library for songs, fetches their genres, and inputs the total 
     * count for that genre into each song's genre.
     ****************************************************************************************/
    public void updateGenreSongCount() {
    	
    	//We'll get the number of songs in a particular genre and apply that tag to all songs.
    	String genre = "";
    	int songCount = 0;
    	int buildingGenresIncrement;
    	currentTask = "Building Genres";
    	if (genresList.size()!=0) {
    		buildingGenresIncrement = 100000/genresList.size();
    	} else {
        	buildingGenresIncrement = 100000/1;
    	}

		//Open a single transaction connection to keep the operation as efficient as possible.    	
    	for (int i=0; i < genresList.size(); i++) {
    		
        	currentProgressValue = currentProgressValue + buildingGenresIncrement;
        	publishProgress();
    		
    		try {
        		genre = genresList.get(i);
        		
        		if (genre.contains("'")) {
        			genre = genre.replace("'", "''");
        		}
        		
        		//Get the number of songs in this genre.
        		songCount = mApp.getDBAccessHelper().getGenreSongCount(genre);
        		mApp.getDBAccessHelper().insertNumberOfSongsInGenre(genre, songCount);
        		
    		} catch (Exception e) {
    			e.printStackTrace();
    			continue;
    		}

    	}
    	
    }

