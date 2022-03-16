	/**
	 * Commit the settings to the database 
	 */
    public void saveSettingsToDB(String songId) {
		
		//Check if a database entry already exists for this song.
		if (mApp.getDBAccessHelper().hasEqualizerSettings(songId)==false) {
			
			//Add a new DB entry.
			mApp.getDBAccessHelper().addSongEQValues(songId,
												 	 mFiftyHertzLevel, 
												 	 mOneThirtyHertzLevel, 
												 	 mThreeTwentyHertzLevel, 
												 	 mEightHundredHertzLevel, 
												 	 mTwoKilohertzLevel, 
												 	 mFiveKilohertzLevel,
												 	 mTwelvePointFiveKilohertzLevel,
												 	 mVirtualizerLevel, 
												 	 mBassBoostLevel, 
												 	 mReverbSetting);
		} else {
			//Update the existing entry.
			mApp.getDBAccessHelper().updateSongEQValues(songId,
												 	    mFiftyHertzLevel, 
												 	    mOneThirtyHertzLevel, 
												 	    mThreeTwentyHertzLevel, 
												 	    mEightHundredHertzLevel, 
												 	    mTwoKilohertzLevel, 
												 	    mFiveKilohertzLevel,
												 	    mTwelvePointFiveKilohertzLevel,
												 	    mVirtualizerLevel, 
												 	    mBassBoostLevel, 
												 	    mReverbSetting);
		}

    }

