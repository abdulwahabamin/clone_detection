    public void getFromLocation(final Context context,
                                            final double latitude,
                                            final double longitude,
                                            int maxResults,
                                            final String locale,
                                            final ProcessResultFromAddressResolution processResultFromAddressResolution) {

        appendLog(context, TAG, "getFromLocation:", latitude, ", ", longitude, ", ", locale);
        final ReverseGeocodingCacheDbHelper mDbHelper = ReverseGeocodingCacheDbHelper.getInstance(context);

        List<Address> addressesFromCache = retrieveLocationFromCache(context, mDbHelper, latitude, longitude, locale);
        if (addressesFromCache != null) {
            processResultFromAddressResolution.processAddresses(addressesFromCache);
            return;
        }

        long now = System.currentTimeMillis();
        if (nextAlowedRequestTimestamp > now) {
            appendLog(context, TAG,
                    "request to nominatim in less than 1.4s - nextAlowedRequestTimestamp=",
                    nextAlowedRequestTimestamp,
                    ", now=",
                    now);
            processResultFromAddressResolution.processCanceledRequest();
            return;
        }

        nextAlowedRequestTimestamp = 1400 + now;
        final String url = String.format(Locale.US, REVERSE_GEOCODE_URL, SERVICE_URL_OSM, "",
                locale.split("_")[0], latitude, longitude);
        appendLog(context, TAG, "Constructed URL ", url);
        Handler mainHandler = new Handler(Looper.getMainLooper());
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                client.get(url, null, new AsyncHttpResponseHandler() {

                    @Override
                    public void onStart() {
                        // called before request is started
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                        try {
                            String rawResult = new String(response);
                            JSONObject result = new JSONObject(rawResult);
                            appendLog(context, TAG, "result from nominatim server:", rawResult);

                            Address address = parseResponse(localeFromLocaleString(locale), result);
                            if (address != null) {
                                List<Address> addresses = new ArrayList<>();
                                addresses.add(address);
                                storeAddressToCache(context, mDbHelper, latitude, longitude, locale, address);
                                processResultFromAddressResolution.processAddresses(addresses);
                            }
                        } catch (JSONException jsonException) {
                            appendLog(context, TAG, "jsonException:", jsonException);
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                        appendLog(context, TAG, "onFailure:", statusCode);
                        processResultFromAddressResolution.processAddresses(null);
                    }

                    @Override
                    public void onRetry(int retryNo) {
                        // called when request is retried
                    }
                });
            }
        };
        mainHandler.post(myRunnable);
    }

