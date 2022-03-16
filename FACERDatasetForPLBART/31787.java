    public void addLocation(View view) {
        if (addLocationDisabled) {
            notifyUserAboutMaxAllowedLocations();
        } else {
            Intent intent = new Intent(LocationsActivity.this, SearchActivity.class);
            startActivity(intent);
        }
    }

