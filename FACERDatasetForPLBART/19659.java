    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSavedInstanceState) {
        mRootView = super.onCreateView(inflater, container, onSavedInstanceState);

        mContext = getActivity().getApplicationContext();
        mApp = (Common) mContext;
        mListView = (ListView) mRootView.findViewById(android.R.id.list);

        //Set the ActionBar background and text color.
        applyKitKatTranslucency();
        getActivity().getActionBar().setTitle(R.string.settings);
        int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
        TextView actionBarText = (TextView) getActivity().findViewById(titleId);
        actionBarText.setTextColor(0xFFFFFFFF);

        mSelectMusicFoldersPreference = getPreferenceManager().findPreference("preference_key_music_folders");
        mRefreshMusicFoldersPreference = getPreferenceManager().findPreference("preference_key_refresh_music_library");

        mSelectMusicFoldersPreference.setOnPreferenceClickListener(selectMusicFoldersClickListener);
        mRefreshMusicFoldersPreference.setOnPreferenceClickListener(refreshMusicFoldersClickListener);

        return mRootView;
    }

