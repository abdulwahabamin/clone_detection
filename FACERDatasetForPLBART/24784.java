    public static void changeButton() {
        changeListButton(PlayerConstants.SONG_NUMBER);
        if(!PlayerConstants.mSongPlayback.isPlay){
            ViewAnimator.animate(mPause, mMiniPause)
                    .alpha(0)
                    .scale(0)
                    .duration(200)
                    .onStop(new AnimationListener.Stop() {
                        @Override
                        public void onStop() {
                            mPause.setVisibility(View.GONE);
                            mMiniPause.setVisibility(View.GONE);
                        }
                    })
                    .start();
            ViewAnimator.animate(mPlay, mMiniPlay)
                    .alpha(0, 1)
                    .scale(0, 1.2f, 1)
                    .duration(400)
                    .onStart(new AnimationListener.Start() {
                        @Override
                        public void onStart() {
                            mPlay.setVisibility(View.VISIBLE);
                            mMiniPlay.setVisibility(View.VISIBLE);
                        }
                    })
                    .startDelay(100)
                    .start();
        }else{
            ViewAnimator.animate(mPlay, mMiniPlay)
                    .alpha(0)
                    .scale(0)
                    .onStop(new AnimationListener.Stop() {
                        @Override
                        public void onStop() {
                            mPlay.setVisibility(View.GONE);
                            mMiniPlay.setVisibility(View.GONE);
                        }
                    })
                    .duration(200)
                    .start();
            ViewAnimator.animate(mPause, mMiniPause)
                    .alpha(0,1)
                    .scale(0,1.2f, 1)
                    .duration(400)
                    .onStart(new AnimationListener.Start() {
                        @Override
                        public void onStart() {
                            mPause.setVisibility(View.VISIBLE);
                            mMiniPause.setVisibility(View.VISIBLE);
                        }
                    })
                    .startDelay(100)
                    .start();
        }
    }

