		@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int position, long dbID) {
			switch (position) {
			case 0:
				((MainActivity) getActivity()).setCurrentFragmentId(Common.ARTISTS_FRAGMENT);
				break;
			case 1:
				((MainActivity) getActivity()).setCurrentFragmentId(Common.ALBUM_ARTISTS_FRAGMENT);
				break;
			case 2:
				((MainActivity) getActivity()).setCurrentFragmentId(Common.ALBUMS_FRAGMENT);
				break;
			case 3:
				((MainActivity) getActivity()).setCurrentFragmentId(Common.SONGS_FRAGMENT);
				break;
			case 4:
				((MainActivity) getActivity()).setCurrentFragmentId(Common.PLAYLISTS_FRAGMENT);
				break;
			case 5:
				((MainActivity) getActivity()).setCurrentFragmentId(Common.GENRES_FRAGMENT);
				break;
			case 6:
				((MainActivity) getActivity()).setCurrentFragmentId(Common.FOLDERS_FRAGMENT);
				break;
            case 7:
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
                break;
			}
			
			//Update the adapter to reflect the new fragment.
			List<String> titles = Arrays.asList(getActivity().getResources().getStringArray(R.array.sliding_menu_array));
			mBrowsersAdapter = new NavigationDrawerAdapter(getActivity(), new ArrayList<String>(titles));
			browsersListView.setAdapter(mBrowsersAdapter);
			
			//Update the fragment.
			((MainActivity) getActivity()).loadFragment(null);
			
			//Reset the ActionBar after 500ms.
			mHandler.postDelayed(new Runnable() {

				@Override
				public void run() {
					getActivity().invalidateOptionsMenu();
					
				}
				
			}, 500);

		}

