	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		mContext = getActivity().getApplicationContext();
		mApp = (Common) mContext;
		
        receiver = new BroadcastReceiver() {
        	
            @Override
            public void onReceive(Context context, Intent intent) {
            	initRepeatSongRangeDialog();
            	
            }
            
        };
		
		sharedPreferences = getActivity().getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_repeat_song_range_dialog, null);
        currentSongIndex = mApp.getService().getCurrentSongIndex();

        repeatSongATime = (TextView) view.findViewById(R.id.repeat_song_range_A_time);
        repeatSongBTime = (TextView) view.findViewById(R.id.repeat_song_range_B_time);

        currentSongDurationMillis = (int) mApp.getService().getCurrentMediaPlayer().getDuration();
        currentSongDurationSecs = (int) currentSongDurationMillis/1000;
        
        //Remove the placeholder seekBar and replace it with the RangeSeekBar.
        seekBar = (SeekBar) view.findViewById(R.id.repeat_song_range_placeholder_seekbar);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) seekBar.getLayoutParams();
        viewGroup = (ViewGroup) seekBar.getParent();
        viewGroup.removeView(seekBar);
        
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
        
        //Set the dialog title.
        builder.setTitle(R.string.a_b_repeat);
        builder.setView(view);
        builder.setNegativeButton(R.string.cancel, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}

        });
        
        builder.setPositiveButton(R.string.repeat, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if ((currentSongDurationSecs - repeatPointB) < mApp.getCrossfadeDuration()) {
					//Remove the crossfade handler.
					mApp.getService().getHandler().removeCallbacks(mApp.getService().startCrossFadeRunnable);
					mApp.getService().getHandler().removeCallbacks(mApp.getService().crossFadeRunnable);
				}
				
				mApp.broadcastUpdateUICommand(new String[] { Common.UPDATE_PLAYBACK_CONTROLS }, 
											  new String[] { "" });
				mApp.getService().setRepeatSongRange(repeatPointA, repeatPointB);
				mApp.getService().setRepeatMode(Common.A_B_REPEAT);
				
			}
        	
        });

        return builder.create();
    }

