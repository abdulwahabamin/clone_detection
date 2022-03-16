    private void praise(final View v, final ImageWeather imageWeather) {
        imageWeather.increment("praise");
        imageWeather.update(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    imageWeather.setPraise(imageWeather.getPraise() + 1);
                    TextView tvPraiseNum = (TextView) v.findViewById(R.id.tv_praise_num);
                    tvPraiseNum.setText(String.valueOf(imageWeather.getPraise()));
                } else {
                    Log.e(TAG, "praise fail", e);
                }
            }
        });
    }

