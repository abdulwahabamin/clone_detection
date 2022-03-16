    @Override
    public void onCreate(Bundle savedInstanceState) {
        mContext = this.getApplicationContext();
        mActivity = this;
        mApp = (Common) mContext;

        setTheme(R.style.SettingsThemeLight);
        super.onCreate(savedInstanceState);

        //Set the ActionBar background and text color.
        getActionBar().setBackgroundDrawable(UIElementsHelper.getGeneralActionBarBackground(mContext));
        getActionBar().setTitle(R.string.settings);
        int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
        TextView actionBarText = (TextView) findViewById(titleId);
        actionBarText.setTextColor(0xFFFFFFFF);

    }

