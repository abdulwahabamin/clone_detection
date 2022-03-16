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

        mAboutAppPreference = getPreferenceManager().findPreference("preference_key_about_app");
        mBasePreference = getPreferenceManager().findPreference("preference_key_player_base_license");
        mThanksPreference = getPreferenceManager().findPreference("preference_key_special_thanks");
        mDevPreference = getPreferenceManager().findPreference("preference_key_about_dev");
        mLicensePreference = getPreferenceManager().findPreference("preference_key_license");
        mNoticePreference = getPreferenceManager().findPreference("preference_key_license_short");

        //Apply the click listeners.
        mAboutAppPreference.setOnPreferenceClickListener(appAboutClickListener);
        mBasePreference.setOnPreferenceClickListener(BaseClickListener);
        mThanksPreference.setOnPreferenceClickListener(ThanksScreenClickListener);
        mDevPreference.setOnPreferenceClickListener(DevClickListener);
        mLicensePreference.setOnPreferenceClickListener(LicenseClickListener);
        mNoticePreference.setOnPreferenceClickListener(NoticeClickListener);

        return mRootView;
    }

