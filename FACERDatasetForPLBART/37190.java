    public static String voiceText(Context context, Weather.DailyForecastEntity forecast) {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        String time;
        if (hour >= 7 && hour < 12) {
            time = "上�?�";
        } else if (hour >= 12 && hour < 19) {
            time = "下�?�";
        } else {
            time = "晚上";
        }

        String weather = forecast.cond.txt_d;
        if (!TextUtils.equals(forecast.cond.txt_d, forecast.cond.txt_n)) {
            weather += "转" + forecast.cond.txt_n;
        }

        String temperature = forecast.tmp.min;
        if (!TextUtils.equals(forecast.tmp.min, forecast.tmp.max)) {
            temperature += "~" + forecast.tmp.max;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(time)
                .append("好")
                .append("，")
                .append(context.getString(R.string.app_name))
                .append("为您播报")
                .append("，")
                .append("今天白天到夜间")
                .append(weather)
                .append("，")
                .append("温度")
                .append(temperature)
                .append("℃")
                .append("，")
                .append(forecast.wind.dir)
                .append(forecast.wind.sc)
                .append(forecast.wind.sc.endsWith("风") ? "" : "级")
                .append("。");
        return sb.toString();
    }

