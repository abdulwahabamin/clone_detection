	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.item_album, null);
		}
		Album album = getItem(position);
		if (album != null) {
			//TextView  textViewLeftBox= (TextView) v.findViewById(R.id.textView_leftBox);
			TextView  textViewAlbumTitle= (TextView) v.findViewById(R.id.textView_album);
			TextView textViewArtist = (TextView) v.findViewById(R.id.textView_artist);

			if (textViewAlbumTitle != null) {
				textViewAlbumTitle.setText(album.getTitle());
			}

			if (textViewArtist != null) {
				textViewArtist.setText(album.getArtist());
			}
		}
		return v;
	}

