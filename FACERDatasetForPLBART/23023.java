		public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
			if (parent.equals(listView)) {
				Album album = (Album) listView.getAdapter().getItem(position);
				MainActivity mainActivity = (MainActivity) getActivity();
				mainActivity.addSongsByAlbumFragment(album);
			}
		}

