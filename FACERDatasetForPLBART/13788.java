    private void startSplashTimer() {
        splashTimer = new CountDownTimer(2000, 1000) {

            public void onTick(long millisUntilFinished) {
                startLogoAnimation();
            }

            public void onFinish() {
                try {
                    startHomeScreenActivity();
                } catch (Exception ex) {
                    splashTimer.cancel();
                }
            }
        }.start();
    }

