    private void SetupClickListener(){
        mNext.setOnClickListener(onNextClickListener);
        mMiniNext.setOnClickListener(onNextClickListener);
        mPrevious.setOnClickListener(onPreviousClickListener);
        mMiniPrevious.setOnClickListener(onPreviousClickListener);
        mMiniPlay.setOnClickListener(onPlayClickListener);
        mPlay.setOnClickListener(onPlayClickListener);
        mPause.setOnClickListener(onPauseClickListener);
        mMiniPause.setOnClickListener(onPauseClickListener);
        mGoDown.setOnClickListener(onGoDownClickListener);
    }

