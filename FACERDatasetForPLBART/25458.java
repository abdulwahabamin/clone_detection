	@Override
	protected void onStart() {
		super.onStart();
        SharedPreferences prefs = getSharedPreferences("PrettyGoodMusicPlayer", MODE_PRIVATE);
        Log.i(TAG, "Preferences " + prefs + " " + ((Object)prefs));
        baseDir = prefs.getString("ARTIST_DIRECTORY", new File(Environment.getExternalStorageDirectory(), "Music").getAbsolutePath());
        Log.d(TAG, "Got configured base directory of " + baseDir);

        populateArtists(baseDir);
        
        simpleAdpt = new SimpleAdapter(this, artists, R.layout.pgmp_list_item, new String[] {"artist"}, new int[] {R.id.PGMPListItemText});
        ListView lv = (ListView) findViewById(R.id.artistListView);
        lv.setAdapter(simpleAdpt);
    }

