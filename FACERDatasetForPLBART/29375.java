    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        birddown_imageview.clearAnimation();
        birdup_imageview.clearAnimation();
        sunshine_imageview.clearAnimation();
        cloud_imageview.clearAnimation();
        Runtime.getRuntime().gc();
    }

