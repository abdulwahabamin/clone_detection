        @Override
        protected void onPostExecute(String response) {
            if(response == null){
                Log.e(LOG_TAG, "Response is null");
                downloadListener.onWeatherDownloadComplete(null, mode);
            } else {
                try {
                    downloadListener.onWeatherDownloadComplete(WeatherDataBuilder.buildWeatherData(response), mode);
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Invalid data");
                    downloadListener.onWeatherDownloadFailed(e);
                }
            }
        }

