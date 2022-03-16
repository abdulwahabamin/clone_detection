    private void prepareTtsLanguages() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ttsAvailableLanguages = tts.getAvailableLanguages();
            if (ttsAvailableLanguages.isEmpty()) {
                timerHandler.postDelayed(timerRunnable, 1000);
                return;
            }
        } else {
            ttsAvailableLanguages = new HashSet<>();
            Locale[] locales = Locale.getAvailableLocales();
            for (Locale loc : locales) {
                if (!loc.toString().toLowerCase().contains("os")
                        && tts.isLanguageAvailable(loc) >= 0) {
                    ttsAvailableLanguages.add(loc);
                }
            }
        }
        populateLanguageOptionsSpinner();
    }

