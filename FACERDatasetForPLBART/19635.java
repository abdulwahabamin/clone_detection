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

        mArtistsPreference = getPreferenceManager().findPreference("preference_key_artists_layout");
        mAlbumArtistsPreference = getPreferenceManager().findPreference("preference_key_album_artists_layout");
        mAlbumsPreference = getPreferenceManager().findPreference("preference_key_albums_layout");
        mPlaylistsPreference = getPreferenceManager().findPreference("preference_key_playlists_layout");
        mGenresPreference = getPreferenceManager().findPreference("preference_key_genres_layout");
        mFoldersPreference = getPreferenceManager().findPreference("preference_key_folders_layout");

        //Apply the click listeners.
        mArtistsPreference.setOnPreferenceClickListener(artistsLayoutClickListener);
        mAlbumArtistsPreference.setOnPreferenceClickListener(albumArtistsClickListener);
        mAlbumsPreference.setOnPreferenceClickListener(albumsLayoutClickListener);
        mPlaylistsPreference.setOnPreferenceClickListener(playlistsClickListener);
        mGenresPreference.setOnPreferenceClickListener(genresClickListener);
        mFoldersPreference.setOnPreferenceClickListener(foldersClickListener);

        return mRootView;
    }

