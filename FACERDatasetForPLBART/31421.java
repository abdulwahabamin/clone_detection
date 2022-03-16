    private void renderTime() {

        if (mEntity != null) {
            renderData(mEntity);
        }

        updateTimeSequence();
        LogUtil.e(TAG, "renderTime");
    }

