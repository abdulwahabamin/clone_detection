    /**
     * 传入上下文和图片�?存路径， 截图并�?存�?功，则返回true
     *
     * @param pActivity
     * @param strName
     * @return
     */
    public static boolean shotBitmap(Activity pActivity, String strName) {
        return ScreenShotUtils.savePic(takeScreenShot(pActivity), strName);
    }

