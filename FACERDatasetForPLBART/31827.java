                @Override
                public void onRefresh() {
                    isNetworkAvailable = connectionDetector.isNetworkAvailableAndConnected();
                    if (isNetworkAvailable) {
                        locationsDbHelper.updateLastUpdatedAndLocationSource(
                                currentLocation.getId(),
                                System.currentTimeMillis(),
                                getString(R.string.location_weather_update_status_update_started));
                        currentLocation = locationsDbHelper.getLocationById(currentLocation.getId());
                        sendMessageToCurrentWeatherService(currentLocation, "MAIN");
                    } else {
                        Toast.makeText(MainActivity.this,
                                R.string.connection_not_found,
                                Toast.LENGTH_SHORT).show();
                        mSwipeRefresh.setRefreshing(false);
                    }
                }

