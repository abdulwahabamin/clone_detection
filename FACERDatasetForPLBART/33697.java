        /**
         * Attempts to obtain the weather data from the provided Open Weather Map URL.
         *
         * @param url Open Weather Map URL
         * @return Json data for the requested city and weather information type, or {@code null}
         * in case of network problems
         */
        private String getJsonStringFromWebService(URL url) {
            try {
                return new JsonFetcher().getJsonString(url);
            } catch (IOException e) {
                return null;
            }
        }

