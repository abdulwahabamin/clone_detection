	@Override
	protected void onCreate(Bundle icicle) {
		
		super.onCreate(icicle);

		addPreferencesFromResource(R.xml.preferences);
		
		Preference editBookmarks = findPreference("editbookmarks");
		editBookmarks.setOnPreferenceClickListener(new OnPreferenceClickListener() {
		    public boolean onPreferenceClick(Preference pref){
		    	showDialog(DIALOG_DELETE_BOOKMARKS);
		        return false;
		    }
		});
		
		/* Register the onSharedPreferenceChanged listener to update the SortBy ListPreference summary */
		getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
		/* Set the onSharedPreferenceChanged listener summary to its initial value */
		changeListPreferenceSummaryToCurrentValue((ListPreference)findPreference("sortby"));
	}

