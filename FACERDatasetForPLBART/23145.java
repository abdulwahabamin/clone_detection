	@Override
	public void onSongChanged() {
		if (songsArrayAdap != null)
			songsArrayAdap.notifyDataSetChanged();

	}

