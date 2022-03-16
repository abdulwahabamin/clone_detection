    @SuppressLint("SetTextI18n")
    public void changeUnit() {
        if (ContentUtil.APP_SETTING_UNIT.equals("hua")) {
            tvTodayMax.setText(TransUnitUtil.getF(todayMaxTmp) + "°");
            tvTodayMin.setText(TransUnitUtil.getF(todayMinTmp) + "°");
            tvTmp.setText(TransUnitUtil.getF(nowTmp) + "°");
        } else {
            tvTodayMax.setText(todayMaxTmp + "°");
            tvTodayMin.setText(todayMinTmp + "°");
            tvTmp.setText(nowTmp + "°");
        }
        getWeatherHourly(weatherHourlyBean);
        getWeatherForecast(weatherForecastBean);
    }

