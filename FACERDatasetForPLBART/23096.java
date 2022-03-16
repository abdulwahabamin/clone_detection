	void addButtonsFragmentIfNotEmpty() {
		if (!playQueue.isEmpty()) {
			// Check if it's already added
			if (fragmentManager.findFragmentById(R.id.fragment_container_buttons) == null) {
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				if (fragmentButtons == null)
					fragmentButtons = new ButtonsFragment();
				fragmentTransaction.add(R.id.fragment_container_buttons, fragmentButtons);
				fragmentTransaction.commit();
			}
		}
	}

