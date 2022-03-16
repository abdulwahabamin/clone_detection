    public void processUpdateOfLocation(final Context context,
                                         Location location) {
        appendLog(context, TAG, "processUpdateOfLocation");
        if (location != null) {
            String locale = PreferenceUtil.getLanguage(context);
            appendLog(context, TAG,
                    "processUpdateOfLocation:location:",
                    location,
                    ":",
                    location.getLatitude(),
                    ", ",
                    location.getLongitude(),
                    ", ",
                    locale);
            NominatimLocationService.getInstance().getFromLocation(
                    context,
                    location.getLatitude(),
                    location.getLongitude(),
                    1,
                    locale,
                    new MozillaProcessResultFromAddressResolution(context, location, this));
            return;
        }
        appendLog(context, TAG, "processUpdateOfLocation:reportNewLocation:", location);
        reportNewLocation(location, null);
    }

