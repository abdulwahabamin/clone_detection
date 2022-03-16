	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//map song.xml to songlayout
		LinearLayout songLayout = (LinearLayout)songInf.inflate(R.layout.song, parent, false);
		
		//get title and artist view
		TextView songView = (TextView)songLayout.findViewById(R.id.song_title);
		TextView songArtist = (TextView)songLayout.findViewById(R.id.song_artist);
		
		//find song using position
		Song currentSong = songList.get(position);
		
		//Title of song and artist
		songView.setText(currentSong.getSongTitle());
		songArtist.setText(currentSong.getSongArtist());
		
		//set position as tag
		songLayout.setTag(position);
		
		return songLayout;
	}

