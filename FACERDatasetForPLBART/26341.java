    @Override
    public void showShareDialog(BaseActivity baseActivity,boolean weather) {
        if(baseActivity.isFinishing()) {
            return;
        }
        try {
            new ShareDialog(baseActivity).show(weather);
        }catch (Exception e) {
            LogHelper.info(TAG,"showShareDialog error %s",e);
        }

    }

