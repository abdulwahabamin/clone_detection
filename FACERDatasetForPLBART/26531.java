    /**
     * called when attached activity or fragment onDestroy called
     */
    @Override
    protected void onCleared() {
        Router.instance().unregister(this);
    }

