    private static Boolean getSlideUporBottom(float last, float now) {
        Boolean isSlideTop = false;
        float getSilde = now - last;
        if (getSilde < 0) {
            getSilde = -getSilde;
        }
        if (getSilde < mSlideHeight) {
            isSlideTop = false;
        } else {
            if (getSilde > mSlideHeight)
                isSlideTop = true;
        }
        return isSlideTop;
    }

