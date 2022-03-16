    /**
     * @see IHttpRequestForCityList#perform(List)
     */
    @Override
    public void perform(List<CityToWatch> cities) {
        IHttpRequest httpRequest = new VolleyHttpRequest(context);
        final String URL = getUrlForQueryingSingleCity(cities.get(0).getCityId(), true);
        httpRequest.make(URL, HttpRequestType.GET, new ProcessOwmAddCityRequest(context));
    }

