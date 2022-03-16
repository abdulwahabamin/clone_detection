    /**
     * Displays the search field.
     */
    private void showSearch() {
    	mSearchLayout.setVisibility(View.VISIBLE);
    	final TranslateAnimation searchAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, 
    														   		 Animation.RELATIVE_TO_SELF, 0f, 
    														   		 Animation.RELATIVE_TO_SELF, -2f, 
    														   		 Animation.RELATIVE_TO_SELF, 0f);
    	searchAnim.setDuration(500l);
    	searchAnim.setInterpolator(new AccelerateDecelerateInterpolator());
    	
    	final TranslateAnimation gridListAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, 
		   		 													   Animation.RELATIVE_TO_SELF, 0f, 
		   		 													   Animation.RELATIVE_TO_SELF, 0f, 
		   		 													   Animation.RELATIVE_TO_SELF, 2f);

    	gridListAnim.setDuration(500l);
    	gridListAnim.setInterpolator(new LinearInterpolator());
    	
    	gridListAnim.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation animation) {
				mListView.setAdapter(null);
				
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationStart(Animation animation) {
				mSearchLayout.startAnimation(searchAnim);
				mSearchLayout.setVisibility(View.VISIBLE);
				
			}
    		
    	});
    	
    	searchAnim.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation animation) {
				if (mSearchEditText.requestFocus()) {
				    mFragment.getActivity()
				    		.getWindow()
				    		.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
				}
				
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    	
    	mListView.startAnimation(gridListAnim);
    	
    }

