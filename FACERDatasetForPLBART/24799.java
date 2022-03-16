    private static Boolean isUp() {
        Boolean isup = false;
        float getY = mBothmusicPlayer.getTranslationY();
        if (getY < 0) {
            isup = true;
        }
        return isup;
    }

