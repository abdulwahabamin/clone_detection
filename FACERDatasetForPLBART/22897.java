    public void transformToPlay(boolean animated) {
        if (!isPlay) {
            if (animated) {
                toggle();
            } else {
                isPlay = true;
                setProgress(1.0F);
            }
        }
    }

