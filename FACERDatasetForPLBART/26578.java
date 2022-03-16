    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.user_settings);
        // show the current value in the settings screen
        for (int i = 0; i < getPreferenceScreen().getPreferenceCount(); i++) {
            initSummary(getPreferenceScreen().getPreference(i));
        }

        LinearLayout root = (LinearLayout)findViewById(android.R.id.list).getParent().getParent().getParent();
        Toolbar bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.toolbar_settings, root, false);
        root.addView(bar, 0); // insert at top

        bar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        bar.setTitleTextColor(getResources().getColor(R.color.background_floating_material_light));

        final Preference prefHistory = (Preference) findPreference("clearhistory");
        prefHistory.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference pref) {
                SearchRecentSuggestions suggestions = new SearchRecentSuggestions(SettingsActivity.this, SearchSugestionProvider.AUTHORITY, SearchSugestionProvider.MODE);
                suggestions.clearHistory();
                return true;
            }
        });
        final Preference prefAbout = (Preference) findPreference("about");
        prefAbout.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference pref) {
                Intent i = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(i);
                return true;
            }
        });
        final Preference prefTranslation = (Preference) findPreference("translation");
        prefTranslation.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference pref) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:tomas.kostadinov@gmx.de?subject=I want to help translating your app!");
                i.setData(data);
                startActivity(i);
                return true;
            }
        });
        final Preference prefHelp = (Preference) findPreference("help");
        prefHelp.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference pref) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:tomas.kostadinov@gmx.de?subject=I need help with your app!");
                i.setData(data);
                startActivity(i);
                return true;
            }
        });
    }

