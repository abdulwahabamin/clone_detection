    @Override
    public void perform(int cityId, int edgeLength, int resultCount) {
        // First, retrieve the city from OWM to have the latitude and longitude for the city
        IHttpRequest httpRequest = new VolleyHttpRequest(context);
        final String URL = getUrlForQueryingSingleCity(cityId, false);
        httpRequest.make(URL, HttpRequestType.GET, new ProcessRadiusSearchRequest(context, edgeLength, resultCount));
    }

