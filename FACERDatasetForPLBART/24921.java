    @Override
    public void onFinishBuildingLibrary(AsyncGetSongList task) {
        try {
            new CountDownTimer(200, 100) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    try {
                        mHandler1.sendEmptyMessage(0);
                    }
                    catch (Exception e)
                    {}
                }
            }.start();
        }
        catch (Exception e)
        {
        }
    }

