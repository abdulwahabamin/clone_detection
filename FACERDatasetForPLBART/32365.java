    private void updateNetworkLocation(Intent intent) {
        if (intent.getExtras() == null) {
            return;
        }
        boolean byLastLocationOnly = intent.getExtras().getBoolean("byLastLocationOnly");
        updateNetworkLocation(byLastLocationOnly, intent, 0);
    }

