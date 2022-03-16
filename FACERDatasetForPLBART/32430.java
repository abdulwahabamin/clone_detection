    private void getLocationFromWifisAndCells(List<ScanResult> scans) {
        appendLog(getBaseContext(), TAG,
                "getLocationFromWifisAndCells(), scans=",
                        scans);
        MozillaLocationService.getInstance(getBaseContext()).getLocationFromCellsAndWifis(getBaseContext(),
                                                                          LocationNetworkSourcesService.getInstance().getCells(getBaseContext(),
                                                                          mTelephonyManager),
                                                                          scans);
    }

