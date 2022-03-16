    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHandleMessageEvent(MessageEvent messageEvent){
        if (messageEvent.getMessage() == UPDATE_CITY){
            mPresenter.loadCities();

        }
    }

