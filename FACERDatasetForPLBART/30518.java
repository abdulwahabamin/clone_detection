    @SuppressLint("SetTextI18n")
    @Override
    public void getWeatherNow(Now bean) {
        if (bean != null && bean.getNow() != null) {
            NowBase now = bean.getNow();
            String rain = now.getPcpn();
            String hum = now.getHum();
            String pres = now.getPres();
            String vis = now.getVis();
            String windDir = now.getWind_dir();
            String windSc = now.getWind_sc();
            String condTxt = now.getCond_txt();
            condCode = now.getCond_code();
            nowTmp = now.getTmp();
            tvCond.setText(condTxt);
            tvTmp.setText(nowTmp + "°");
            if (ContentUtil.APP_SETTING_UNIT.equals("hua")) {
                tvTmp.setText(TransUnitUtil.getF(nowTmp) + "°");
            }
            tvTodayRain.setText(rain + "mm");
            tvTodayPressure.setText(pres + "HPA");
            tvTodayHum.setText(hum + "%");
            tvTodayVisible.setText(vis + "KM");
            tvWindDir.setText(windDir);
            tvWindSc.setText(windSc + "级");
            DateTime nowTime = DateTime.now();
            int hourOfDay = nowTime.getHourOfDay();
            if (hourOfDay > 6 && hourOfDay < 19) {
                ivBack.setImageResource(IconUtils.getDayBack(condCode));
            } else {
                ivBack.setImageResource(IconUtils.getNightBack(condCode));
            }
            if (isEn) {
                tvWindSc.setText("Level" + windSc);
            }
            swipeRefreshLayout.setRefreshing(false);
        }
    }

