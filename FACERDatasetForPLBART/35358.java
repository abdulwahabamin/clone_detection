    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onHandleBackground(MessageEvent event){
        if (event.getMessage() == UPDATE_WEATHER){
            ImageUtils.drawImage(MyApplication.getAppContext(),ImageUtils.BRIEF);
        }
    }

