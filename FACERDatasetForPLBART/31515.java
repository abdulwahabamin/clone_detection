    private void stopAnimation() {
        mHandler.removeCallbacks(rainProc);
        mHandler.removeCallbacks(snowProc);
        mHandler.removeCallbacks(cloudProc);
        mHandler.removeCallbacks(lightningProc);
        mHandler.removeCallbacks(sunshaineProc);
        for (int i = 0; i != rlBackgroundView.getChildCount(); ++i) {
            View view = rlBackgroundView.getChildAt(i);
            if (view != null) {
                view.clearAnimation();
            }
        }
        rlBackgroundView.removeAllViews();
        mSpecialWeatherNumRain = 0;
        mSpecialWeatherNumCloud = 0;
        mSpecialWeatherNumSnow = 0;
        mSpecialWeatherNumLightning = 0;
    }

