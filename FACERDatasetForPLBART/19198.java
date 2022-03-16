		@Override
		public void onPostExecute(Void result) {
			super.onPostExecute(result);
			
			TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, 
					  											  Animation.RELATIVE_TO_SELF, 0.0f, 
					  											  Animation.RELATIVE_TO_SELF, 2.0f, 
					  											  Animation.RELATIVE_TO_SELF, 0.0f);

			animation.setDuration(600);
			animation.setInterpolator(new AccelerateDecelerateInterpolator());
			
        	mListViewAdapter = new ListViewCardsAdapter(mContext, mFragment, mDBColumnsMap);
	        mListView.setAdapter(mListViewAdapter);
            mListView.setOnItemClickListener(onItemClickListener);
	        
	     /* SwingBottomInAnimationAdapter animationAdapter = new SwingBottomInAnimationAdapter(mListViewAdapter);
	        animationAdapter.setShouldAnimate(true);
	        animationAdapter.setShouldAnimateFromPosition(0);
	        animationAdapter.setAbsListView(mListView);
	        mListView.setAdapter(animationAdapter); */
	        
	        //Init the quick scroll widget.
	        mQuickScroll.init(QuickScroll.TYPE_INDICATOR_WITH_HANDLE, 
	        				  mListView,
	        				  (ListViewCardsAdapter) mListViewAdapter,
	        				  QuickScroll.STYLE_HOLO);
	        
	        int[] quickScrollColors = UIElementsHelper.getQuickScrollColors(mContext);
            PauseOnScrollHelper scrollListener = new PauseOnScrollHelper(mApp.getPicasso(), null, true, true);

            mQuickScroll.setOnScrollListener(scrollListener);
            mQuickScroll.setPicassoInstance(mApp.getPicasso());
	        mQuickScroll.setHandlebarColor(quickScrollColors[0], quickScrollColors[0], quickScrollColors[1]);
	        mQuickScroll.setIndicatorColor(quickScrollColors[1], quickScrollColors[0], quickScrollColors[2]);
	        mQuickScroll.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 48);
	        
	        animation.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationEnd(Animation arg0) {
					mQuickScroll.setVisibility(View.VISIBLE);
					
				}

				@Override
				public void onAnimationRepeat(Animation arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onAnimationStart(Animation arg0) {
					mListView.setVisibility(View.VISIBLE);
					
				}
	        	
	        });
	        
	        mListView.startAnimation(animation);
			
		}

