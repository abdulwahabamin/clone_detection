    @Override
    public void onItemClick(View view, Object data) {
        ImageWeather imageWeather = (ImageWeather) data;
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                new Pair<>(view.findViewById(R.id.iv_image), Extras.VIEW_NAME_WEATHER_IMAGE));
        ViewImageActivity.start(this, imageWeather, activityOptions);
    }

