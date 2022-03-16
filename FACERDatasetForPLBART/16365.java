    /**
     * �?始化toasty
     *
     * @param colorId 颜色
     */
    protected void initToast(@ColorRes int colorId) {
        Toasty.Config.getInstance().setInfoColor(AppUtils.getColor(colorId)).apply();
    }

