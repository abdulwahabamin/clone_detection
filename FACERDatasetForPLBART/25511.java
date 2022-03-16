	@Override
	@Deprecated
	public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
			Preference preference) {
		// TODO clean this up a bunch.
		Log.i(TAG, "User clicked " + preference.getTitle());
		if (preference.getKey().equals("choose_music_directory_prompt")) {
			final File path = Utils.getRootStorageDirectory();
			DirectoryPickerOnClickListener picker = new DirectoryPickerOnClickListener(
					this, path);
			picker.showDirectoryPicker();
			Log.i(TAG, "User selected " + picker.path);
			return true;
		}
		return super.onPreferenceTreeClick(preferenceScreen, preference);
	}

