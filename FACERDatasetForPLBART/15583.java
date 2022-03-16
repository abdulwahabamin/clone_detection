    public void onCollapsed(){
    	mPrev.setVisibility(View.VISIBLE);
    	mNext.setVisibility(View.VISIBLE);
    	mPlay.setVisibility(View.VISIBLE);
    	
    	mQueue.setImageResource(R.drawable.btn_switch_queue);
    	mQueue.setVisibility(View.GONE);
        
        listQueue.setVisibility(View.GONE);
        albumArt.setVisibility(View.VISIBLE);

        fade(listQueue, 0f);
        // Fade in the album art
        fade(albumArt, 1f);
    }

