	private void addAlbumFragment() {
		currentFragment = FRAGMENT_ALBUMS;
		album = null;
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		if (fragmentAlbums == null)
			fragmentAlbums = new AlbumsFragment();
		fragmentTransaction.replace(R.id.fragment_container_lists, fragmentAlbums);
		fragmentTransaction.commit();
		setTitle(getResources().getString(R.string.app_name) + " - " + getResources().getString(R.string.albums));

	}

