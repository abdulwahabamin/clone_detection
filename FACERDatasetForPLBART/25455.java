	private void populateArtists(String baseDir){
		artists = new ArrayList<Map<String,String>>();
		File f = new File(baseDir);
		if(!f.exists() || !f.isDirectory()){
			Log.e(TAG, "Storage directory " + f + " does not exist!");
			return;
		}
		
		List<String> artistDirs = new ArrayList<String>();

		if(f.listFiles() != null) {
			for (File dir : f.listFiles()) {
				if (Utils.isValidArtistDirectory(dir)) {
					artistDirs.add(dir.getName());
				}
			}

			Collections.sort(artistDirs, new Comparator<String>() {

				@Override
				public int compare(String arg0, String arg1) {
					SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ArtistList.this);
					boolean ignoreleadingthe = sharedPref.getBoolean("ignore_leading_the_in_artist", false);
					if (ignoreleadingthe) {
						if (arg0.toLowerCase().startsWith("the ")) {
							arg0 = arg0.substring(4);
						}
						if (arg1.toLowerCase().startsWith("the ")) {
							arg1 = arg1.substring(4);
						}
					}
					return (arg0.toUpperCase().compareTo(arg1.toUpperCase()));
				}

			});

            artistDirs.add(0,"All");

			for (String artist : artistDirs) {
				Log.v(TAG, "Adding artist " + artist);
				// listview requires a map
				Map<String, String> map = new HashMap<String, String>();
				map.put("artist", artist);
				artists.add(map);
			}
		}

		if(!f.exists() || artistDirs.isEmpty()){
			Map<String, String> map = new HashMap<String, String>();
			map.put("artist", PICK_DIR_TEXT);
			artists.add(map);
		}
	}

