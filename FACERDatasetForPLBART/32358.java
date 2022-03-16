    private void startLocationUpdateOnly(Intent intent) {
        if (intent.getExtras() == null) {
            return;
        }
        Location inputLocation = null;
        if (intent.getExtras().getParcelable("inputLocation") != null) {
            inputLocation = (Location) intent.getExtras().getParcelable("inputLocation");
        }
        Address addresses = null;
        if (intent.getExtras().getParcelable("addresses") != null) {
            addresses = (Address) intent.getExtras().getParcelable("addresses");
        }
        appendLog(getBaseContext(), TAG, "LOCATION_UPDATE recieved:", inputLocation, ":", addresses);
        onLocationChanged(inputLocation, addresses);
    }

