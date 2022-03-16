	public void setUpQueueSwitch(Activity activity) {
		// TODO Auto-generated method stub
		albumArt = (RelativeLayout) activity.findViewById(R.id.audio_player_album_art_wrapper);
        listQueue = (RelativeLayout) activity.findViewById(R.id.audio_player_queue_wrapper);
        mQueue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(albumArt.getVisibility()==View.VISIBLE){
            		listQueue.removeAllViews();
            		getFragmentManager().beginTransaction().add(R.id.audio_player_queue_wrapper, new NowPlayingFragment(), "NowPlayingTag").commit();
            		mQueue.setImageResource(R.drawable.btn_switch_queue_active);
                    albumArt.setVisibility(View.GONE);
                    listQueue.setVisibility(View.VISIBLE);
                    // Fade out the pager container
                    fade(albumArt, 0f);
                    // Fade in the album art
                    fade(listQueue, 1f);
            	}
            	else{
                    listQueue.setVisibility(View.GONE);
                    albumArt.setVisibility(View.VISIBLE);
            		mQueue.setImageResource(R.drawable.btn_switch_queue);
                    // Fade out the pager container
                    fade(listQueue, 0f);
                    // Fade in the album art
                    fade(albumArt, 1f);
            	}
            	
            }
        });
		
	}

