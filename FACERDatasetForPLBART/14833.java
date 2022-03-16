	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//instantiate the songView and songList
		songView = (ListView)findViewById(R.id.song_list);
		songList = new ArrayList<Song>();
		
		getSongList();
		
		//sort the songs based on title
		//can also sort based on artist
		Collections.sort(songList, new Comparator<Song>( ){
			public int compare(Song a, Song b){
				return a.getSongTitle().compareTo(b.getSongTitle());
			}
		});
		
		SongAdaptor songADPT = new SongAdaptor(this, songList);		
		songView.setAdapter(songADPT);
		
		setController( );
	}

