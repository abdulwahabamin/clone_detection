	/**
	 * Saves premade equalizer presets to the database.
	 */
	private void saveEQPresets() {
		Cursor eqPresetsCursor = mApp.getDBAccessHelper().getAllEQPresets();
        
		//Check if this is the first startup (eqPresetsCursor.getCount() will be 0).
        if (eqPresetsCursor!=null && eqPresetsCursor.getCount()==0) {
        	mApp.getDBAccessHelper().addNewEQPreset("Flat", 16, 16, 16, 16, 16, 16, 16, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Bass Only", 31, 31, 31, 0, 0, 0, 31, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Treble Only", 0, 0, 0, 31, 31, 31, 0, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Rock", 16, 18, 16, 17, 19, 20, 22, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Grunge", 13, 16, 18, 19, 20, 17, 13, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Metal", 12, 16, 16, 16, 20, 24, 16, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Dance", 14, 18, 20, 17, 16, 20, 23, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Country", 16, 16, 18, 20, 17, 19, 20, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Jazz", 16, 16, 18, 18, 18, 16, 20, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Speech", 14, 16, 17, 14, 13, 15, 16, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Classical", 16, 18, 18, 16, 16, 17, 18, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Blues", 16, 18, 19, 20, 17, 18, 16, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Opera", 16, 17, 19, 20, 16, 24, 18, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Swing", 15, 16, 18, 20, 18, 17, 16, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("Acoustic", 17, 18, 16, 19, 17, 17, 14, (short) 0, (short) 0, (short) 0);
        	mApp.getDBAccessHelper().addNewEQPreset("New Age", 16, 19, 15, 18, 16, 16, 18, (short) 0, (short) 0, (short) 0);

        }
        
        //Close the cursor.
        if (eqPresetsCursor!=null)
        	eqPresetsCursor.close();
        
	}

