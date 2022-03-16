    /**
     * Method invoked when an action item is clicked.
     *
     * @param view The button pushed
     */
    public void onActionBarItemClick(View view) {
        switch (view.getId()) {
            case R.id.ab_button1:
                //Settings
                Intent settings = new Intent(this, SettingsPreferences.class);
                settings.putExtra(
                        PreferenceActivity.EXTRA_SHOW_FRAGMENT,
                        SearchPreferenceFragment.class.getName());
                startActivity(settings);
                break;

            default:
                break;
        }
    }

