	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mainActivity = (MainActivity) AlbumSongsFragment.this.getActivity();
		listView = (ListView) getView().findViewById(R.id.listView_songs);
		registerForContextMenu(listView);
		songsArrayAdap = new SongsArrayAdapter(getActivity(), android.R.layout.simple_list_item_1);
		listView.setAdapter(songsArrayAdap);
		listView.setOnItemClickListener(songSelectedListener);
		contentResolver = getActivity().getContentResolver();
	}

