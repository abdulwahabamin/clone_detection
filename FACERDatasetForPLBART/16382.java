    /**
     * æ˜¾ç¤ºtoasty
     *
     * @param text æ??ç¤ºä¿¡æ?¯
     */
    public void showToasty(String text) {
        Toasty.info(AppUtils.getContext(), text, Toast.LENGTH_SHORT, false).show();
    }

