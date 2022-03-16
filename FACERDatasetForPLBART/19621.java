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

        mAppThemePreference = getPreferenceManager().findPreference("preference_key_app_theme");
        mColorPreference = getPreferenceManager().findPreference("preference_key_player_color_scheme");
        mDefaultScreenPreference = getPreferenceManager().findPreference("preference_key_startup_screen");
        mLockscreenControlsPreference = (CheckBoxPreference) getPreferenceManager().findPreference("preference_key_lockscreen_controls");

        //Apply the click listeners.
        mAppThemePreference.setOnPreferenceClickListener(appThemeClickListener);
        mColorPreference.setOnPreferenceClickListener(colorClickListener);
        mDefaultScreenPreference.setOnPreferenceClickListener(defaultScreenClickListener);
        mLockscreenControlsPreference.setOnPreferenceChangeListener(lockscreenControlsClickListener);

        return mRootView;
    }

