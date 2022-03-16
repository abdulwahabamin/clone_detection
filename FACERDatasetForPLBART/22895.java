    public void transformToPause(boolean animated) {
        if (isPlay) {
            if (animated) {
                toggle();
            } else {
                isPlay = false;
                setProgress(0.0F);
            }
        }
    }

