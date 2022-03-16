    public void startLocationUpdateCellsOnly() {
        appendLog(getBaseContext(), TAG,
                "LOCATION_UPDATE_CELLS_ONLY:nextScanningAllowedFrom:",
                nextScanningAllowedFrom);
        if (nextScanningAllowedFrom == null) {
            return;
        }
        nextScanningAllowedFrom = null;
        scanning = false;
        getLocationFromWifisAndCells(null);
    }

