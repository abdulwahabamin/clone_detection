    /**
     * 显示toasty
     *
     * @param text �??示信�?�
     */
    public void showToasty(String text) {
        Toasty.info(AppUtils.getContext(), text, Toast.LENGTH_SHORT, false).show();
    }

