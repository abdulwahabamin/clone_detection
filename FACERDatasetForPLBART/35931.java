        public ApiConfiguration build() {
            if (dataSourceType != ApiConstants.WEATHER_DATA_SOURCE_TYPE_KNOW
                    && dataSourceType != ApiConstants.WEATHER_DATA_SOURCE_TYPE_MI
                    && dataSourceType != ApiConstants.WEATHER_DATA_SOURCE_TYPE_ENVIRONMENT_CLOUD) {
                throw new IllegalStateException("The dataSourceType does not support!");
            }
            return new ApiConfiguration(this);
        }

