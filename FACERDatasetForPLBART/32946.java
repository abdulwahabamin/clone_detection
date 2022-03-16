    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((YourLocalWeather) getApplication()).applyTheme(this);
        super.onCreate(savedInstanceState);
        applicationLocale = new Locale(PreferenceUtil.getLanguage(this));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
        setContentView(R.layout.activity_voice_language_options);

        setupActionBar();
        TextView appLang = findViewById(R.id.pref_title_tts_lang_app_locale_id);
        appLang.setText(getString(R.string.pref_title_tts_lang_app_locale) + " " + applicationLocale.getDisplayName());
        TextView ttsAppGeneralInfo = findViewById(R.id.pref_title_tts_app_general_info_id);
        Linkify.addLinks(ttsAppGeneralInfo, Linkify.WEB_URLS);
        voiceSettingParametersDbHelper = VoiceSettingParametersDbHelper.getInstance(this);
    }

