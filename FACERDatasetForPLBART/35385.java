    @Override
    public void onReceiveLocation(final BDLocation location) {
        String city = location.getCity();
        if (city != null) {
            final String name = city.substring(0, city.length() - 1);
            EventBus.getDefault().post(new CityNameMessage(name));
        } else if (location.getLocType() == BDLocation.TypeNetWorkException) {

            Toast.makeText(MyApplication.getAppContext(), "网络�?�?�导致定�?失败，请检查网络是�?�通畅", Toast.LENGTH_LONG).show();
        } else if (location.getLocType() == BDLocation.TypeCriteriaException) {

            Toast.makeText(MyApplication.getAppContext(), "无法获�?�有效定�?�?�?�导致定�?失败，一般是由于手机的原因，处于飞行模�?下一般会造�?这�?结果，�?�以试�?��?�?�手机", Toast.LENGTH_LONG).show();
        }

        MyApplication.getmLocationClient().stop();

    }

