    private void startAnimation(WeatherEntity entity) {
        stopAnimation();

        if (entity != null) {
            int animationType = 0;
            String weatherDesc = entity.getWeatherDescription();
            if (weatherDesc.equalsIgnoreCase(getString(R.string.light_rain))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.drizzle_rain))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.drizzle_rain_1))) {
                animationType |= ANIMATION_RAIN_L;
            }
            if (weatherDesc.equalsIgnoreCase(getString(R.string.shower_rain))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.thunder_shower))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.moderate_rain))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.freezing_rain))) {
                animationType |= ANIMATION_RAIN_M;
            }
            if (weatherDesc.equalsIgnoreCase(getString(R.string.heavy_shower_rain))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.heavy_thunderstorm))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.hail))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.heavy_rain))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.extreme_rain))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.storm))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.heavy_storm))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.severe_storm))) {
                animationType |= ANIMATION_RAIN_H;
            }
            if (weatherDesc.equalsIgnoreCase(getString(R.string.light_snow))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.sleet))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.rain_snow))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.shower_snow))) {
                animationType |= ANIMATION_SNOW_L;
            }
            if (weatherDesc.equalsIgnoreCase(getString(R.string.moderate_snow))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.snow_flurry))) {
                animationType |= ANIMATION_SNOW_M;
            }
            if (weatherDesc.equalsIgnoreCase(getString(R.string.heavy_snow))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.snow_storm))) {
                animationType |= ANIMATION_SNOW_H;
            }
            if (weatherDesc.equalsIgnoreCase(getString(R.string.cloudy))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.partly_cloudy))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.few_cloud))) {
                animationType |= ANIMATION_CLOUD_D;
            }
            if (weatherDesc.equalsIgnoreCase(getString(R.string.mist))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.foggy))) {
                animationType |= ANIMATION_CLOUD_F;
            }
            if (weatherDesc.equalsIgnoreCase(getString(R.string.sunny))) {
                animationType |= ANIMATION_SUNSHINE;
            }
            if (weatherDesc.equalsIgnoreCase(getString(R.string.thunder_shower))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.heavy_thunderstorm))
                    || weatherDesc.equalsIgnoreCase(getString(R.string.hail))) {
                animationType |= ANIMATION_LIGHTNING;
            }

            if (animationType == 0)
                animationType = mAnimationType;

            if ((animationType & ANIMATION_RAIN_L) != 0) {
                mRainIconId = R.drawable.raindrop_l;
                mSpecialWeatherNumLimitRain = RAIN_NUM_L;
                mSpecialWeatherSpeedLimitRain = RAIN_SPEED_L;
                mHandler.postDelayed(rainProc, 20);
            }
            if ((animationType & ANIMATION_RAIN_M) != 0) {
                mRainIconId = R.drawable.raindrop_m;
                mSpecialWeatherNumLimitRain = RAIN_NUM_M;
                mSpecialWeatherSpeedLimitRain = RAIN_SPEED_M;
                mHandler.postDelayed(rainProc, 20);
            }
            if ((animationType & ANIMATION_RAIN_H) != 0) {
                mRainIconId = R.drawable.raindrop_h;
                mSpecialWeatherNumLimitRain = RAIN_NUM_H;
                mSpecialWeatherSpeedLimitRain = RAIN_SPEED_H;
                mHandler.postDelayed(rainProc, 20);
            }
            if ((animationType & ANIMATION_SNOW_L) != 0) {
                mSnowIconLightId = R.drawable.snow_light_l;
                mSnowIconDarkId = R.drawable.snow_dark_l;
                mSpecialWeatherNumLimitSnow = RAIN_NUM_L;
                mSpecialWeatherSpeedLimitSnow = SNOW_SPEED_L;
                mHandler.postDelayed(snowProc, 20);
            }
            if ((animationType & ANIMATION_SNOW_M) != 0) {
                mSnowIconLightId = R.drawable.snow_light_m;
                mSnowIconDarkId = R.drawable.snow_dark_m;
                mSpecialWeatherNumLimitSnow = RAIN_NUM_M;
                mSpecialWeatherSpeedLimitSnow = SNOW_SPEED_M;
                mHandler.postDelayed(snowProc, 20);
            }
            if ((animationType & ANIMATION_SNOW_H) != 0) {
                mSnowIconLightId = R.drawable.snow_light_h;
                mSnowIconDarkId = R.drawable.snow_dark_h;
                mSpecialWeatherNumLimitSnow = RAIN_NUM_H;
                mSpecialWeatherSpeedLimitSnow = SNOW_SPEED_H;
                mHandler.postDelayed(snowProc, 20);
            }
            if ((animationType & ANIMATION_CLOUD_D) != 0) {
                mCloudIconBackId = R.drawable.cloudy_day_1;
                mCloudIconFrontId = R.drawable.cloudy_day_2;
                mSpecialWeatherNumLimitCloud = 2;
                mHandler.postDelayed(cloudProc, 20);
            }
            if ((animationType & ANIMATION_CLOUD_N) != 0) {
                mCloudIconBackId = R.drawable.cloudy_night1;
                mCloudIconFrontId = R.drawable.cloudy_night2;
                mSpecialWeatherNumLimitCloud = 2;
                mHandler.postDelayed(cloudProc, 20);
            }
            if ((animationType & ANIMATION_CLOUD_F) != 0) {
                mCloudIconBackId = R.drawable.fog_cloud_1;
                mCloudIconFrontId = R.drawable.fog_cloud_2;
                mSpecialWeatherNumLimitCloud = 2;
                mHandler.postDelayed(cloudProc, 20);
            }
            if ((animationType & ANIMATION_LIGHTNING) != 0) {
                mSpecialWeatherNumLimitLightning = 2;
                mHandler.postDelayed(lightningProc, 20);
            }
            if ((animationType & ANIMATION_SUNSHINE) != 0) {
                mHandler.postDelayed(sunshaineProc, 20);
            }
        }
    }

