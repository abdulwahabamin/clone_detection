    public void switchLocation(View arg0) {
        int newLocationOrderId = 1 + currentLocation.getOrderId();
        currentLocation = locationsDbHelper.getLocationByOrderId(newLocationOrderId);

        if (currentLocation == null) {
            newLocationOrderId = 0;
            currentLocation = locationsDbHelper.getLocationByOrderId(newLocationOrderId);
            if ((currentLocation.getOrderId() == 0) && !currentLocation.isEnabled() && (locationsDbHelper.getAllRows().size() > 1)) {
                newLocationOrderId++;
                currentLocation = locationsDbHelper.getLocationByOrderId(newLocationOrderId);
            }
        }

        AppPreference.setCurrentLocationId(this, currentLocation);
        localityView.setText(Utils.getCityAndCountry(this, newLocationOrderId));
        updateUI();
    }

