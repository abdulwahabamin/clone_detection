    @Override
    public void navigateToCitiesActivity(String locCityId, boolean locateSucceeded, String cityId) {
        mCityId = cityId;
        mLocateCityId = locCityId;
        mIsLocateSucceeded = locateSucceeded;
        Message message = mHandler.obtainMessage(MSG_NAVIGATE_CITIES);
        message.sendToTarget();
    }

