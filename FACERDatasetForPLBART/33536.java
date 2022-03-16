    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mi_add_city) {
            showAddCityDialog();
        } else if (id == R.id.mi_city_management) {
            Intent cityManagementIntent = new Intent(this, CityManagementActivity.class);
            startActivityWithTransitionAnimation(cityManagementIntent);
        } else if (id == R.id.mi_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivityWithTransitionAnimation(settingsIntent);
        } else if (id == R.id.mi_rate_application) {
            goToPlayStore();
        } else if (id == R.id.mi_about) {
            Intent aboutIntent = new Intent(this, AboutActivity.class);
            startActivityWithTransitionAnimation(aboutIntent);
        }
        return super.onOptionsItemSelected(item);
    }

