    private void progress() {
        fabProgressCircle.onArcAnimationComplete();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fabProgressCircle.hide();
            }
        }, 500);
    }

