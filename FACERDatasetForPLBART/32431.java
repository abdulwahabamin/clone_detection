    private PendingIntent getIntentToGetCellsOnly() {
        Intent intent = new Intent(getBaseContext(), NetworkLocationProvider.class);
        intent.setAction("org.openbmap.unifiedNlp.LOCATION_UPDATE_CELLS_ONLY");
        return PendingIntent.getService(getBaseContext(),
                0,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT);
    }

