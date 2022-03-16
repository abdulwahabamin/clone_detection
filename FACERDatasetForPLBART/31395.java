        @Override
        public void onNext(WeatherEntity weatherEntity) {
            if (mCallback != null) {
                mCallback.renderData(weatherEntity);
            }
        }

