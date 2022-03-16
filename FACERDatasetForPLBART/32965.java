    private void processTtsLanguages(Set<Locale> ttsAvailableLanguages) {
        boolean supportedLanguage = false;
        appendLog(getBaseContext(), TAG, "Locales:ttsAvailableLanguages: " + ttsAvailableLanguages + ":" + ((ttsAvailableLanguages != null) ? ttsAvailableLanguages.size() : ""));
        for (Locale locale : ttsAvailableLanguages) {
            appendLog(getBaseContext(), TAG, "Locales: ", locale.getISO3Language(), ":", applicationLocale.getISO3Language());
            if (locale.getISO3Language().equals(applicationLocale.getISO3Language())) {
                supportedLanguage = true;
            }
        }
        if (!supportedLanguage) {
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(getBaseContext(), getString(R.string.pref_title_tts_not_supported), duration);
            toast.show();
        }
    }

