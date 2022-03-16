    public static final void setupMusicPlayer(){
        if (PlayerConstants.SONG_NUMBER>-1)
        {
            if (mBothmusicPlayer.getVisibility()==View.INVISIBLE)
            {
                ViewAnimator.animate(mBothmusicPlayer)
                        .alpha(0,1)
                        .onStart(new AnimationListener.Start() {
                            @Override
                            public void onStart() {
                                mBothmusicPlayer.setVisibility(View.VISIBLE);
                            }
                        })
                        .duration(400)
                        .start();
                SetupMargin(true);
            }
            else
            {

                SetupMargin(true);
            }
        }
        else {
            mBothmusicPlayer.setVisibility(View.INVISIBLE);
            SetupMargin(false);
        }
    }

