    @SuppressLint("SetTextI18n")
    @Override
    public void getWeatherHourly(Hourly bean) {
        if (bean != null && bean.getHourly() != null) {
            weatherHourlyBean = bean;
            List<HourlyBase> hourlyWeatherList = bean.getHourly();
            List<HourlyBase> data = new ArrayList<>();
            if (hourlyWeatherList.size() > 23) {
                for (int i = 0; i < 24; i++) {
                    data.add(hourlyWeatherList.get(i));
                    String condCode = data.get(i).getCond_code();
                    String time = data.get(i).getTime();
                    time = time.substring(time.length() - 5, time.length() - 3);
                    int hourNow = Integer.parseInt(time);
                    if (hourNow >= 6 && hourNow <= 19) {
                        data.get(i).setCond_code(condCode + "d");
                    } else {
                        data.get(i).setCond_code(condCode + "n");
                    }
                }
            } else {
                for (int i = 0; i < hourlyWeatherList.size(); i++) {
                    data.add(hourlyWeatherList.get(i));
                    String condCode = data.get(i).getCond_code();
                    String time = data.get(i).getTime();
                    time = time.substring(time.length() - 5, time.length() - 3);
                    int hourNow = Integer.parseInt(time);
                    if (hourNow >= 6 && hourNow <= 19) {
                        data.get(i).setCond_code(condCode + "d");
                    } else {
                        data.get(i).setCond_code(condCode + "n");
                    }
                }
            }

            int minTmp = Integer.parseInt(data.get(0).getTmp());
            int maxTmp = minTmp;
            for (int i = 0; i < data.size(); i++) {
                int tmp = Integer.parseInt(data.get(i).getTmp());
                minTmp = Math.min(tmp, minTmp);
                maxTmp = Math.max(tmp, maxTmp);
            }
            //设置当天的最高最低温度
            hourlyForecastView.setHighestTemp(maxTmp);
            hourlyForecastView.setLowestTemp(minTmp);
            if (maxTmp == minTmp) {
                hourlyForecastView.setLowestTemp(minTmp - 1);
            }
            hourlyForecastView.initData(data);
            tvLineMax.setText(maxTmp + "°");
            tvLineMin.setText(minTmp + "°");
            if (ContentUtil.APP_SETTING_UNIT.equals("hua")) {
                tvLineMax.setText(TransUnitUtil.getF(String.valueOf(maxTmp)) + "°");
                tvLineMin.setText(TransUnitUtil.getF(String.valueOf(minTmp)) + "°");
            }
        }
    }

