    public synchronized void getLocationFromCellsAndWifis(final Context context,
                                                          List<Cell> cells,
                                                          List<ScanResult> wiFis) {
        appendLog(context, TAG,
                "getLocationFromCellsAndWifis:wifi=",
                wiFis,
                ", cells=",
                cells);
        if ((cells == null || cells.isEmpty()) && (wiFis == null || wiFis.size() < 2)) {
            appendLog(context, TAG, "THERE IS NO CELL AND JUST ONE WIFI NETWORK - THIS IS NOT ENOUGH FOR MLS TO GET THE LOCATION");
            processUpdateOfLocation(context, null);
            return;
        }
        try {
            final String request = createRequest(cells, wiFis);
            final StringEntity entity = new StringEntity(request);
            Handler mainHandler = new Handler(Looper.getMainLooper());
            Runnable myRunnable = new Runnable() {
                @Override
                public void run() {
                    client.post(context,
                                String.format(SERVICE_URL, API_KEY),
                                entity,
                                "application/json",
                                new AsyncHttpResponseHandler() {

                        @Override
                        public void onStart() {
                            // called before request is started
                        }

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] httpResponse) {
                            Location response = null;
                            try {
                                String result = new String(httpResponse);
                                appendLog(context, TAG, "response: ", result);
                                JSONObject responseJson = new JSONObject(result);
                                double lat = responseJson.getJSONObject("location").getDouble("lat");
                                double lon = responseJson.getJSONObject("location").getDouble("lng");
                                double acc = responseJson.getDouble("accuracy");
                                response = create(PROVIDER, lat, lon, (float) acc);
                                processUpdateOfLocation(context, response);
                            } catch (JSONException e) {
                                appendLog(context, TAG, e.toString());
                                processUpdateOfLocation(context, null);
                            }
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                            appendLog(context, TAG, "onFailure:", statusCode);
                            processUpdateOfLocation(context, null);
                        }

                        @Override
                        public void onRetry(int retryNo) {
                            // called when request is retried
                        }
                    });
                }
            };
            mainHandler.post(myRunnable);
        } catch (Exception e) {
            Log.w(TAG, e);
        }
    }

