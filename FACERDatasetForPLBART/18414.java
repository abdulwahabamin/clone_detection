    /**
     * Returns a cursor with all EQ presets in the table.
     */
    public Cursor getAllEQPresets() {
    	String query = "SELECT * FROM " + EQUALIZER_PRESETS_TABLE;
    	return getDatabase().rawQuery(query, null);
    	
    }

