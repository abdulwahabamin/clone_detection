    @Override
    public void updateItem(AqiData data, int position) {
        WeatherData.AqiEntity aqiEntity = data.aqiData;
        if (Check.isNull(aqiEntity)) {
            return;
        }

        upDateLevel(aqiView, aqiValue, Integer.parseInt(aqiEntity.getAqi()));
        upDateLevel(pm2_5View, pm2_5Value, Integer.parseInt(aqiEntity.getPm25()));
        upDateLevel(pm10View, pm10Value, Integer.parseInt(aqiEntity.getPm10()));
        aqiQuality.setText(aqiEntity.getQuality());
//        aqiAdvice.setText(aqiEntity.getAdvice());

//        SpannableString rankSpannable = new SpannableString(aqiEntity.getCityRank());
//        rankSpannable.setSpan(new ForegroundColorSpan(UIUtil.getColor(getContext(), R.color.colorAccent)), 8, 11, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
//        rankSpannable.setSpan(new RelativeSizeSpan(1.3f), 8, 11, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
//        rank.setText(rankSpannable);


    }

