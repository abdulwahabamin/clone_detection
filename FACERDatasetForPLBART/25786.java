    @OnClick(R.id.life_advice)
    void onClick() {
        Router.instance().getReceiver(WeatherCallBack.LifeAdvice.class).lifeAdvice(getContext().getString(R.string.weather_lifeIndexes), getContext().getString(R.string.weather_lifeIndexes));
        mLifeAdvice.setVisibility(View.GONE);

    }

