        @Override
        public void run() {
            TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
					  											  Animation.RELATIVE_TO_SELF, 0.0f,
					  											  Animation.RELATIVE_TO_SELF, 2.0f,
					  											  Animation.RELATIVE_TO_SELF, 0.0f);

			animation.setDuration(150);
			animation.setInterpolator(new AccelerateDecelerateInterpolator());

            mGridViewAdapter = new GridViewCardsAdapter(mContext, mFragment, mDBColumnsMap);
            //mGridView.setAdapter(mGridViewAdapter);

            //GridView animation adapter.
            final SwingBottomInAnimationAdapter animationAdapter = new SwingBottomInAnimationAdapter(mGridViewAdapter, 100, 150);
            animationAdapter.setShouldAnimate(true);
            animationAdapter.setShouldAnimateFromPosition(0);
            animationAdapter.setAbsListView(mGridView);
            mGridView.setAdapter(animationAdapter);
            mGridView.setOnItemClickListener(onItemClickListener);

            //Init the quick scroll widget.
            mQuickScroll.init(QuickScrollGridView.TYPE_INDICATOR_WITH_HANDLE,
                              mGridView,
                              (GridViewCardsAdapter) mGridViewAdapter,
                              QuickScrollGridView.STYLE_HOLO);

            int[] quickScrollColors = UIElementsHelper.getQuickScrollColors(mContext);
            PauseOnScrollHelper scrollHelper = new PauseOnScrollHelper(mApp.getPicasso(), null, false, true);

            mQuickScroll.setOnScrollListener(scrollHelper);
            mQuickScroll.setPicassoInstance(mApp.getPicasso());
            mQuickScroll.setHandlebarColor(quickScrollColors[0], quickScrollColors[0], quickScrollColors[1]);
            mQuickScroll.setIndicatorColor(quickScrollColors[1], quickScrollColors[0], quickScrollColors[2]);
            mQuickScroll.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 48);

	        animation.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationEnd(Animation arg0) {
					mQuickScroll.setVisibility(View.VISIBLE);
                    //animationAdapter.setShouldAnimate(false);

				}

				@Override
				public void onAnimationRepeat(Animation arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationStart(Animation arg0) {
					mGridView.setVisibility(View.VISIBLE);

				}

	        });

	        mGridView.startAnimation(animation);
        }

