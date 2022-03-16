        @Override
        public void onReceive(Context context, Intent intent) {
        	
        	//Grab the bundle from the intent.
        	Bundle bundle = intent.getExtras();

        	//Initializes the ViewPager.
        	if (intent.hasExtra(Common.INIT_PAGER) || 
        		intent.hasExtra(Common.NEW_QUEUE_ORDER))
                initViewPager();

        	//Updates the ViewPager's current page/position.
        	if (intent.hasExtra(Common.UPDATE_PAGER_POSTIION)) {
                int currentPosition = mViewPager.getCurrentItem();
                int newPosition = Integer.parseInt(bundle.getString(Common.UPDATE_PAGER_POSTIION));
                if (currentPosition!=newPosition) {

                    if (newPosition > 0 && Math.abs(newPosition - currentPosition) <= 5) {
                        //Smooth scroll to the new index.
                        scrollViewPager(newPosition, true, 1, false);
                    } else {
                        //The new index is too far away, so avoid smooth scrolling to it.
                        mViewPager.setCurrentItem(newPosition, false);
                    }

                    //Reinit the seekbar update handler.
                    mHandler.post(seekbarUpdateRunnable);

                }

        	}
        		
        	//Updates the playback control buttons.
        	if (intent.hasExtra(Common.UPDATE_PLAYBACK_CONTROLS)) {
        		setPlayPauseButton();
        		setRepeatButtonIcon();
        		setShuffleButtonIcon();
        		
        	}
        	
            //Displays the audibook toast.
        	if (intent.hasExtra(Common.SHOW_AUDIOBOOK_TOAST))
        		displayAudiobookToast(Long.parseLong(
        							  bundle.getString(
        							  Common.SHOW_AUDIOBOOK_TOAST)));
        	
        	//Updates the duration of the SeekBar.
        	if (intent.hasExtra(Common.UPDATE_SEEKBAR_DURATION))
        		setSeekbarDuration(Integer.parseInt(
        						   bundle.getString(
        						   Common.UPDATE_SEEKBAR_DURATION)));
        	
        	//Hides the seekbar and displays the streaming progress bar.
        	if (intent.hasExtra(Common.SHOW_STREAMING_BAR)) {
        		mSeekbar.setVisibility(View.INVISIBLE);
        		mStreamingProgressBar.setVisibility(View.VISIBLE);
        		mHandler.removeCallbacks(seekbarUpdateRunnable);
        		
        	}
        	
        	//Shows the seekbar and hides the streaming progress bar.
        	if (intent.hasExtra(Common.HIDE_STREAMING_BAR)) {
        		mSeekbar.setVisibility(View.VISIBLE);
        		mStreamingProgressBar.setVisibility(View.INVISIBLE);
        		mHandler.postDelayed(seekbarUpdateRunnable, 100);
        	}
        	
        	//Updates the buffering progress on the seekbar.
        	if (intent.hasExtra(Common.UPDATE_BUFFERING_PROGRESS))
        		mSeekbar.setSecondaryProgress(Integer.parseInt(
        									  bundle.getString(
        									  Common.UPDATE_BUFFERING_PROGRESS)));

        	//Close this activity if the service is about to stop running.
        	if (intent.hasExtra(Common.SERVICE_STOPPING)) {
        		mHandler.removeCallbacks(seekbarUpdateRunnable);
        		finish();
        	}
        	
        }

