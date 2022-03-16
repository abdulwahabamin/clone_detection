    /**
     * 进行�?幕截图
     *
     * @param pActivity
     * @return
     */
    public static Bitmap takeScreenShot(Activity pActivity) {
        Bitmap bitmap = null;
        View view = pActivity.getWindow().getDecorView();
        // 设置是�?��?�以进行绘图缓存
        view.setDrawingCacheEnabled(true);
        // 如果绘图缓存无法，强制构建绘图缓存
        view.buildDrawingCache();
        // 返回这个缓存视图
        bitmap = view.getDrawingCache();
        // 获�?�状�?�?高度
        Rect frame = new Rect();
        // 测�?�?幕宽和高
        view.getWindowVisibleDisplayFrame(frame);
        int stautsHeight = frame.top;

        @SuppressWarnings("deprecation") int width = pActivity.getWindowManager().getDefaultDisplay().getWidth();
        @SuppressWarnings("deprecation") int height = pActivity.getWindowManager().getDefaultDisplay().getHeight();
        // 根�?��??标点和需�?的宽和高创建bitmap
        bitmap = Bitmap.createBitmap(bitmap, 0, stautsHeight, width, height - stautsHeight);
        return bitmap;
    }

