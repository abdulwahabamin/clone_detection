	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		super.onPrepareOptionsMenu(menu);

		mIncludeMediaScanMenuItem.setVisible(false);
		mExcludeMediaScanMenuItem.setVisible(false);
		
		boolean showMediaScanMenuItem = PreferenceActivity.getMediaScanFromPreference(this);
		
 		// We only know about ".nomedia" once we have the results list back.
 		if (showMediaScanMenuItem && mListDir != null) {
			if (mNoMedia) {
				mIncludeMediaScanMenuItem.setVisible(true);
			} else {
				mExcludeMediaScanMenuItem.setVisible(true);
 			}
 		}

		// Generate any additional actions that can be performed on the
		// overall list. This allows other applications to extend
		// our menu with their own actions.
		Intent intent = new Intent(null, getIntent().getData());
		intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
		// menu.addIntentOptions(Menu.CATEGORY_ALTERNATIVE, 0, 0,
		// new ComponentName(this, NoteEditor.class), null, intent, 0, null);

		// Workaround to add icons:
		MenuIntentOptionsWithIcons menu2 = new MenuIntentOptionsWithIcons(this,
				menu);
		menu2.addIntentOptions(Menu.CATEGORY_ALTERNATIVE, 0, 0,
				new ComponentName(this, FileManagerActivity.class), null, intent,
				0, null);

		return true;
	}

