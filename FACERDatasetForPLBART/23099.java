	void addPlayQueueFragment() {
		currentFragment = FRAGMENT_PLAY_QUEUE;
		album = null;
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		if (fragmentPlayQueue == null)
			fragmentPlayQueue = new PlayQueueFragment();
		fragmentTransaction.replace(R.id.fragment_container_lists, fragmentPlayQueue);
		fragmentTransaction.commit();
		setTitle(getResources().getString(R.string.play_queue));
	}

