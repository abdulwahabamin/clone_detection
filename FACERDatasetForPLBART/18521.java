	public void initRepeatSongRangeDialog() {

        currentSongDurationMillis = (int) mApp.getService().getCurrentMediaPlayer().getDuration();
        currentSongDurationSecs = (int) currentSongDurationMillis/1000;
        
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) rangeSeekBar.getLayoutParams();
        viewGroup = (ViewGroup) rangeSeekBar.getParent();
        viewGroup.removeView(rangeSeekBar);
        
        rangeSeekBar = new RangeSeekBar<Integer>(0, currentSongDurationSecs, getActivity());
        rangeSeekBar.setLayoutParams(params);
        viewGroup.addView(rangeSeekBar);
		
        if (sharedPreferences.getInt(Common.REPEAT_MODE, Common.REPEAT_OFF)==Common.A_B_REPEAT) {
        	repeatSongATime.setText(convertMillisToMinsSecs(mApp.getService().getRepeatSongRangePointA()));
        	repeatSongBTime.setText(convertMillisToMinsSecs(mApp.getService().getRepeatSongRangePointB()));
        	rangeSeekBar.setSelectedMinValue(mApp.getService().getRepeatSongRangePointA());
        	rangeSeekBar.setSelectedMaxValue(mApp.getService().getRepeatSongRangePointB());
        	repeatPointA = mApp.getService().getRepeatSongRangePointA();
        	repeatPointB = mApp.getService().getRepeatSongRangePointB();
        } else {
        	repeatSongATime.setText("0:00");
        	repeatSongBTime.setText(convertMillisToMinsSecs(currentSongDurationMillis));
        	repeatPointA = 0;
        	repeatPointB = currentSongDurationMillis;
        }
        
        rangeSeekBar.setOnRangeSeekBarChangeListener(new OnRangeSeekBarChangeListener<Integer>() {

            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
            	repeatPointA = minValue*1000;
            	repeatPointB = maxValue*1000;
            	repeatSongATime.setText(convertMillisToMinsSecs(minValue*1000));
            	repeatSongBTime.setText(convertMillisToMinsSecs(maxValue*1000));
            }
            
        });
        
	}

