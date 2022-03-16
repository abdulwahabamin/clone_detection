    private void updateData() {
        if (!TextUtils.isEmpty(searchQuery)) {
            setProgressBarVisible(true);
            Call<GeoCities> responseCall = service.findCity(
                    searchQuery, MAX_CITIES_LIST_SIZE, Locale.getDefault().getLanguage(),
                    CITIES_STYLE, BuildConfig.GEONAME_API_KEY);
            responseCall.enqueue(new Callback<GeoCities>() {
                @Override
                public void onResponse(Call<GeoCities> call, Response<GeoCities> response) {
                    if (!response.body().getCities().isEmpty()) {
                        addCities(response.body().getCities());
                        setCityListVisible(true);
                        setProgressBarVisible(false);
                    } else {
                        showCouldNotFindCity();
                    }
                }
                @Override
                public void onFailure(Call<GeoCities> call, Throwable t) {
                    Log.e(LOG_TAG,"error:"+t.getMessage());
                    showCouldNotFindCity();
                    setProgressBarVisible(false);
                }
            });
        } else {
            clear();
            setImageViewVisible(true);
            setSearchStateVisible(true);
            setCityListVisible(false);
            showStartTyping();
        }
    }

