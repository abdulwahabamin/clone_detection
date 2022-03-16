    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity=getActivity();
        // Read in the flag indicating whether or not the user has demonstrated awareness of the
        // drawer. See PREF_USER_LEARNED_DRAWER for details.
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }

        // Select either the default item (0) or the last selected item.
        selectItem(mCurrentSelectedPosition);
        items.clear();
        items.add(new Holder(R.drawable.nav_btn_txt,activity.getString(R.string.text_files)));
        items.add(new Holder(R.drawable.nav_btn_videos,activity.getString(R.string.nav_videos)));
        items.add(new Holder(R.drawable.nav_btn_images,activity.getString(R.string.nav_images)));
        items.add(new Holder(R.drawable.nav_btn_download,activity.getString(R.string.nav_downloads)));
        items.add(new Holder(R.drawable.nav_btn_documents,activity.getString(R.string.nav_documents)));
        items.add(new Holder(R.drawable.nav_btn_music, activity.getString(R.string.nav_music)));


    }

