    private void updatePreferences(Preference p) {
        if (p instanceof EditTextPreference) {
            EditTextPreference editTextPref = (EditTextPreference) p;
            p.setSummary(editTextPref.getText());
        } else if(p instanceof ListPreference) {
            ListPreference listpref = (ListPreference) p;
            p.setSummary(listpref.getEntry());
        }
    }

