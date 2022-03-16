    public void startLocationUpdate(Location inputLocation) {
        if (nextScanningAllowedFrom != null) {
            Calendar now = Calendar.getInstance();
            if (now.before(nextScanningAllowedFrom)) {
                return;
            }
        }
        if (inputLocation != null) {
            MozillaLocationService.getInstance(getBaseContext()).processUpdateOfLocation(getBaseContext(), inputLocation);
        } else {
            sendUpdateToLocationBackends();
        }
    }

