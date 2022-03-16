    private void updateCurrentLocationAndButtonVisibility() {
        currentLocation = locationsDbHelper.getLocationById(AppPreference.getCurrentLocationId(getApplicationContext()));
        if (currentLocation == null) {
            currentLocation = locationsDbHelper.getLocationByOrderId(0);
        }
        switchToNextLocationWhenCurrentIsAutoAndIsDisabled();
        if (mToolbarMenu != null) {
            if ((currentLocation.getOrderId() == 0) && !currentLocation.isEnabled()) {
                mToolbarMenu.findItem(R.id.main_menu_refresh).setVisible(false);
            } else {
                mToolbarMenu.findItem(R.id.main_menu_refresh).setVisible(true);
            }
            Location autoLocation = locationsDbHelper.getLocationByOrderId(0);
            if (!autoLocation.isEnabled()) {
                mToolbarMenu.findItem(R.id.main_menu_detect_location).setVisible(false);
            } else {
                mToolbarMenu.findItem(R.id.main_menu_detect_location).setVisible(true);
            }
        }
        AppPreference.setCurrentLocationId(this, currentLocation);
        int maxOrderId = locationsDbHelper.getMaxOrderId();
        if ((maxOrderId > 1) ||
                ((maxOrderId == 1) && (locationsDbHelper.getLocationByOrderId(0).isEnabled()))) {
            switchLocationButton.setVisibility(View.VISIBLE);
        } else {
            switchLocationButton.setVisibility(View.GONE);
        }
    }

