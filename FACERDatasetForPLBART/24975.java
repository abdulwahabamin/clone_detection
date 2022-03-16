    private void updateTheme() {
        String theme = ((RhythmApp) getApplication()).getSelectedTheme();
        int nightMode = AppCompatDelegate.MODE_NIGHT_NO;
        if (theme.equals("dark")) {
            nightMode = AppCompatDelegate.MODE_NIGHT_YES;
        }
        if (theme.equals("auto")) {
            nightMode = AppCompatDelegate.MODE_NIGHT_AUTO;
        }
        AppCompatDelegate.setDefaultNightMode(nightMode);
        getDelegate().applyDayNight();
    }

