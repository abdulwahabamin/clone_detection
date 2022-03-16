    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHandleMessageEvent(MessageEvent event){
        if (event.getMessage() == UPDATE_SHOW_CITY){
            toolbar.setTitle(mHomePresenter.getShowCity());
        }
    }

