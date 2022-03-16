	@Override
	public void onResume() {
		super.onResume();

        if (mIsCreating==false) {
            setKitKatTranslucentBars();
            mHandler.postDelayed(seekbarUpdateRunnable, 100);
            mIsCreating = false;
        }

        //Animate the controls bar in.
        //animateInControlsBar();
        //Update the seekbar.
        try {
            setSeekbarDuration(mApp.getService().getCurrentMediaPlayer().getDuration()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Load the drawer 1000ms after the activity is loaded.
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                initDrawer();
            }

        }, 1000);

		if (getIntent().hasExtra(START_SERVICE) &&
			getNowPlayingActivityListener()!=null) {
			getNowPlayingActivityListener().onNowPlayingActivityReady();

			/**
			 * To prevent the service from being restarted every time this
			 * activity is resume, we're gonna have to remove the "START_SERVICE"
			 * extra from the intent.
			 */
			getIntent().removeExtra(START_SERVICE);

		}

	}

