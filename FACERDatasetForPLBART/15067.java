    /**
     * Performs the web-service call. If the <code>session</code> parameter is
     * <code>non-null</code> then an authenticated call is made. If it's
     * <code>null</code> then an unauthenticated call is made.<br/>
     * The <code>apiKey</code> parameter is always required, even when a valid
     * session is passed to this method.
     * 
     * @param method The method to call
     * @param apiKey A Last.fm API key
     * @param params Parameters
     * @param session A Session instance or <code>null</code>
     * @return the result of the operation
     */
    private Result call(String method, String apiKey, Map<String, String> params, Session session) {
        params = new HashMap<String, String>(params); // create new Map in case
                                                      // params is an immutable
                                                      // Map
        InputStream inputStream = null;

        // no entry in cache, load from web
        if (inputStream == null) {
            // fill parameter map with apiKey and session info
            params.put(PARAM_API_KEY, apiKey);
            if (session != null) {
                params.put("sk", session.getKey());
            }
            try {
                HttpURLConnection urlConnection = openPostConnection(method, params);
                inputStream = getInputStreamFromConnection(urlConnection);

                if (inputStream == null) {
                    this.lastResult = Result.createHttpErrorResult(urlConnection.getResponseCode(),
                            urlConnection.getResponseMessage());
                    return lastResult;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Result result = createResultFromInputStream(inputStream);
            this.lastResult = result;
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

