        private void updateLocationsLocale(String newLocale) {
            LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getActivity());
            for (Location location: locationsDbHelper.getAllRows()) {
                locationsDbHelper.updateLocale(location.getId(), newLocale);
            }
        }

