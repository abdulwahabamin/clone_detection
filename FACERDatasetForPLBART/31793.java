    private void updateAddLocationButton(List<Location> allLocations) {
        int locationsCount = allLocations.size();
        if (!allLocations.get(0).isEnabled()) {
            locationsCount--;
        }
        if (locationsCount >= ApiKeys.getAvailableLocations(this)) {
            addLocationButton.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
            addLocationDisabled = true;
        } else {
            addLocationButton.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(0xde, 0x44, 0x4e)));
            addLocationDisabled = false;
        }
    }

