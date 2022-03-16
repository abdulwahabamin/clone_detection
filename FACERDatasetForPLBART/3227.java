    public static AlphaAnimation animateAlphaFlash() {
        AlphaAnimation animation1 = new AlphaAnimation(0.2f, 1.0f);
        animation1.setDuration(200);
        animation1.setStartOffset(50);
        animation1.setFillAfter(true);
        return animation1;
    }

