	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.item_song, null);
		}
		Song song = getItem(position);
		if (song != null) {
			TextView textViewLeftBox = (TextView) v.findViewById(R.id.textView_leftBox);
			TextView textViewSong = (TextView) v.findViewById(R.id.textView_song);
			if (textViewLeftBox != null) {
				if (song.isPlaying()) {
					textViewLeftBox.setBackgroundColor(getContext().getResources().getColor(R.color.blue_ics));
				}else{
					textViewLeftBox.setBackgroundColor(getContext().getResources().getColor(R.color.dim_grey));
				}
			}
			if (textViewSong != null) {
				textViewSong.setText(song.getTitle());
			}
		}
		return v;
	}

