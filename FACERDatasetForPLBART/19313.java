    	public void run() {
    		
    		try {
                long currentPosition = mApp.getService().getCurrentMediaPlayer().getCurrentPosition();
                int currentPositionInSecs = (int) currentPosition/1000;
                smoothScrollSeekbar(currentPositionInSecs);

                //mSeekbar.setProgress(currentPositionInSecs);
                mHandler.postDelayed(seekbarUpdateRunnable, 100);

    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    	}

