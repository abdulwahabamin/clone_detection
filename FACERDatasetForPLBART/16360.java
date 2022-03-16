    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getP() != null) {
            getP().detachV();
        }
        p = null;
        unbinder.unbind();
        BaseApplication.getInstance().finishActivity(this);
    }

