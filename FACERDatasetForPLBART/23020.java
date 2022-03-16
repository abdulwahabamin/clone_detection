	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		listView = (ListView) getView().findViewById(R.id.listView_albums);
		albumsArrayAdapter = new AlbumsArrayAdapter(getActivity(), android.R.layout.simple_list_item_1);
		listView.setAdapter(albumsArrayAdapter);
		listView.setOnItemClickListener(albumSelectedListener);
		contentResolver = getActivity().getContentResolver();
	}

