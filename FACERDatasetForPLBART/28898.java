    /**
     * @see IHttpRequestForCityList#perform(List)
     */
    @Override
    public void perform(List<CityToWatch> cities) {
        IHttpRequest httpRequest = new VolleyHttpRequest(context);
        final String URL = getUrlForQueryingGroupIDs(joinCityIDs(cities));
        httpRequest.make(URL, HttpRequestType.GET, new ProcessOwmUpdateCityListRequest(context));
    }

