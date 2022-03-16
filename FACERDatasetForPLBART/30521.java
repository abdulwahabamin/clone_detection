    @Override
    public void getAirNow(AirNow bean) {
        if (bean != null && bean.getAir_now_city() != null) {
            ivLine.setVisibility(View.VISIBLE);
            gridAir.setVisibility(View.VISIBLE);
            rvAir.setVisibility(View.VISIBLE);
            tvAirTitle.setVisibility(View.VISIBLE);
            AirNowCity airNowCity = bean.getAir_now_city();
            String qlty = airNowCity.getQlty();
            String aqi = airNowCity.getAqi();
            String pm25 = airNowCity.getPm25();
            String pm10 = airNowCity.getPm10();
            String so2 = airNowCity.getSo2();
            String no2 = airNowCity.getNo2();
            String co = airNowCity.getCo();
            String o3 = airNowCity.getO3();
            tvAir.setText(qlty);
            tvAirNum.setText(aqi);
            tvTodayPm25.setText(pm25);
            tvTodayPm10.setText(pm10);
            tvTodaySo2.setText(so2);
            tvTodayNo2.setText(no2);
            tvTodayCo.setText(co);
            tvTodayO3.setText(o3);
            rvAir.setBackground(getAirBackground(aqi));
        } else {
            ivLine.setVisibility(View.GONE);
            gridAir.setVisibility(View.GONE);
            rvAir.setVisibility(View.GONE);
            tvAirTitle.setVisibility(View.GONE);
        }
    }

