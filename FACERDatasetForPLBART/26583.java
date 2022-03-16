    private void initSummary(Preference p) {
        if (p instanceof PreferenceCategory) {
            PreferenceCategory cat = (PreferenceCategory) p;
            for (int i = 0; i < cat.getPreferenceCount(); i++) {
                initSummary(cat.getPreference(i));
            }
        } else if(p instanceof ListPreference) {
            ListPreference listpref = (ListPreference) p;
            p.setSummary(listpref.getEntry());
        } else {
            updatePreferences(p);
        }
    }

