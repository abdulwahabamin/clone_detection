	void addSongsByAlbumFragment(Album album) {
		currentFragment = FRAGMENT_SONGS_ALBUM;
		this.album = album;
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		if (fragmentSongsAlbum == null)
			fragmentSongsAlbum = new AlbumSongsFragment();
		fragmentSongsAlbum.setAlbum(album);
		fragmentTransaction.replace(R.id.fragment_container_lists, fragmentSongsAlbum);
		fragmentTransaction.commit();
		setTitle(album.getTitle() + " - " + album.getArtist());
	}

