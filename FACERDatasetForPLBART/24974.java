    @Override
    protected void onResume() {
        super.onResume();
        updateTheme();
        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if (currentNightMode != ((RhythmApp) getApplication()).getCurrentNighMode()) {
            ((RhythmApp) getApplication()).setCurrentNightMode(currentNightMode);
            recreate();
        }
    }

