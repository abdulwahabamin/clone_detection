    public void show(boolean isWeather) {
        if (mDialog == null) {
            return;
        }
        List<ShareData> shareDatas = new ArrayList<>();
        for (int SHARE_ICON : ShareHolder.SHARE_ICONS) {
            shareDatas.add(new ShareData(isWeather, this));
        }
        mTitle.setText(isWeather ? R.string.core_share_weather : R.string.core_share_app);
        mShareAdapter.setData(shareDatas);
        mDialog.show();
    }

