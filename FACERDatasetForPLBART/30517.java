    public void changeTextSize() {
        if (!TextUtils.isEmpty(sunrise) && !TextUtils.isEmpty(sunset) && !TextUtils.isEmpty(moonRise) && !TextUtils.isEmpty(moonSet)) {
            DateTime now = DateTime.now(DateTimeZone.UTC);
            float a = Float.valueOf(tz);
            float minute = a * 60;
            now = now.plusMinutes(((int) minute));
            currentTime = now.toString("HH:mm");
            sunView.setTimes(sunrise, sunset, currentTime);
            moonView.setTimes(moonRise, moonSet, currentTime);
            hasAni = true;
        }

        getWeatherForecast(weatherForecastBean);

        if (!ContentUtil.APP_PRI_TESI.equalsIgnoreCase(ContentUtil.APP_SETTING_TESI)) {
            switch (ContentUtil.APP_PRI_TESI) {
                case "small":
                    if ("mid".equalsIgnoreCase(ContentUtil.APP_SETTING_TESI)) {
                        smallMid(textViewList);
                    } else if ("large".equalsIgnoreCase(ContentUtil.APP_SETTING_TESI)) {

                        smallLarge(textViewList);
                    }
                    break;
                case "mid":
                    if ("small".equalsIgnoreCase(ContentUtil.APP_SETTING_TESI)) {
                        midSmall(textViewList);
                    } else if ("large".equalsIgnoreCase(ContentUtil.APP_SETTING_TESI)) {
                        midLarge(textViewList);
                    }
                    break;
                case "large":
                    if ("small".equalsIgnoreCase(ContentUtil.APP_SETTING_TESI)) {
                        largeSmall(textViewList);
                    } else if ("mid".equalsIgnoreCase(ContentUtil.APP_SETTING_TESI)) {
                        largeMid(textViewList);
                    }
                    break;
            }
        }
    }

