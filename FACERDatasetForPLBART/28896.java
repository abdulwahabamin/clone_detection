        /**
         * @see IHttpRequestForRadiusSearchResults#perform()
         */
        @Override
        public void perform() {
            // In the second step the actual weather data are fetched and processed
            IHttpRequest httpRequest = new VolleyHttpRequest(context);
            final String URL = getUrlForQueryingRadiusSearch(boundingBox, mapZoom);
            httpRequest.make(
                    URL,
                    HttpRequestType.GET,
                    new ProcessRadiusSearchRequest(context, 0, 0).new ProcessRadiusSearchResultRequest(context, resultCount)
            );
        }

