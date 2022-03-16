        /**
         * Constructor.
         *
         * @param boundingBox The bounding box. Determines the search square. The first value in the
         *                    array is the left longitude, second bottom latitude, third right
         *                    longitude, fourth top latitude.
         * @param mapZoom     Defines the map zoom to use. For further details see the comment in
         *                    ProcessRadiusSearchRequest#processSuccessScenario
         */
        public OwmHttpRequestForResults(Context context, int resultCount, double[] boundingBox, int mapZoom) {
            this.context = context;
            this.resultCount = resultCount;
            this.boundingBox = boundingBox;
            this.mapZoom = mapZoom;
        }

