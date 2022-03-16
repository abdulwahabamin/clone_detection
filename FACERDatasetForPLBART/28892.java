    /**
     * @see IHttpRequestForForecast#perform(int)
     */
    @Override
    public void perform(int cityId) {
        IHttpRequest httpRequest = new VolleyHttpRequest(context);
        final String URL = getUrlForQueryingForecast(cityId);
        httpRequest.make(URL, HttpRequestType.GET, new ProcessOwmForecastRequest(context));
    }

