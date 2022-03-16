    private void performDone() {
        if (selectedCity == null) {
            Toast.makeText(activity, R.string.dialog_add_no_city_found, Toast.LENGTH_SHORT).show();
            return;
        }
        if(database != null && !database.isCityWatched(selectedCity.getCityId())) {
            addCity();
        }

        activity.recreate();
        dismiss();
    }

