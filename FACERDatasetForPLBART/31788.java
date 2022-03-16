    private void notifyUserAboutMaxAllowedLocations() {
        Snackbar.make(
                findViewById(android.R.id.content),
                getString(R.string.snackbar_add_location_disabled, ApiKeys.getAvailableLocations(this)),
                Snackbar.LENGTH_LONG).show();
    }

