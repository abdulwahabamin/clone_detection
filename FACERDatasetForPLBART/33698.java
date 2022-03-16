        @Override
        protected void onPostExecute(Pair<String, Long> weatherInfo) {
            super.onPostExecute(weatherInfo);

            String jsonString = weatherInfo.first;
            if (jsonString == null) {
                if (parentActivity != null) {
                    Toast.makeText(parentActivity, R.string.error_message_no_connection,
                            Toast.LENGTH_SHORT).show();
                }
            } else if (listener != null && isWeatherDataAvailable(jsonString)) {
                long time = weatherInfo.second;
                if (CURRENT_TIME_WEB == time) {
                    listener.onRecentJsonStringRetrieved(jsonString, weatherInfoType, true);
                } else if (CURRENT_TIME_SQL == time) {
                    listener.onRecentJsonStringRetrieved(jsonString, weatherInfoType, false);
                } else {
                    listener.onOldJsonStringRetrieved(jsonString, weatherInfoType, time);
                }
            } else if (parentActivity != null) {
                Toast.makeText(parentActivity, R.string.error_message_no_data,
                        Toast.LENGTH_LONG).show();
            }
        }

