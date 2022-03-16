    /**
     * @see IProcessHttpRequest#processSuccessScenario(String)
     */
    @Override
    public void processSuccessScenario(String response) {
        // The following value is the fifth parameter for the bounding box and represents the
        // map zoom, as explained here as of 2016-08-12:
        // https://github.com/renkun-ken/rlist-tutorial/blob/master/Examples/Weather-API.Rmd
        // It is set to 10 because this seems to be a good granularity for this project
        final int MAP_ZOOM = 10;

        IDataExtractor extractor = new OwmDataExtractor();
        double[] latitudeLongitude = extractor.extractLatitudeLongitude(response);
        if (latitudeLongitude.length > 0) {
            double[] boundingBox = getBoundingBox(latitudeLongitude, edgeLength);
            IHttpRequestForRadiusSearchResults owmHttpRequestForResults =
                    new OwmHttpRequestForRadiusSearch(null).new OwmHttpRequestForResults(context, resultCount, boundingBox, MAP_ZOOM);
            owmHttpRequestForResults.perform();
        }
    }

