    /**
     * Saves the EQ settings to the database for the specified song.
     */
    public void setEQValuesForSong(String songId) {
    	
    	//Grab the EQ values for the specified song.
    	int[] currentEqValues = mApp.getDBAccessHelper().getSongEQValues(songId);
		
		//Check if a database entry already exists for this song.
		if (currentEqValues[10]==0) {
			//Add a new DB entry.
			mApp.getDBAccessHelper().addSongEQValues(songId, 
									 				 fiftyHertzLevel, 
									 				 oneThirtyHertzLevel, 
									 				 threeTwentyHertzLevel, 
									 				 eightHundredHertzLevel, 
									 				 twoKilohertzLevel, 
									 				 fiveKilohertzLevel,
									 				 twelvePointFiveKilohertzLevel,
									 				 virtualizerLevel, 
									 				 bassBoostLevel, 
									 				 reverbSetting);
		} else {
			//Update the existing entry.
			mApp.getDBAccessHelper().updateSongEQValues(songId, 
									 			   		fiftyHertzLevel, 
									 			   		oneThirtyHertzLevel, 
									 			   		threeTwentyHertzLevel, 
									 			   		eightHundredHertzLevel, 
									 			   		twoKilohertzLevel, 
									 			   		fiveKilohertzLevel, 
									 			   		twelvePointFiveKilohertzLevel, 
									 			   		virtualizerLevel, 
									 			   		bassBoostLevel, 
									 			   		reverbSetting);
		}

    }

