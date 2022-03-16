    @Override
    public void onDestroy() {
        super.onDestroy();
        Router.instance().unregister(this);

    }

