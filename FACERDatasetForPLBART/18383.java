        @Override
        public void run() {
            android.view.animation.TranslateAnimation animation = new
                    android.view.animation.TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 2.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f);

            animation.setDuration(150);
            animation.setInterpolator(new AccelerateDecelerateInterpolator());

            mListViewAdapter = new BrowserSubListAdapter(mContext, BrowserSubListActivity.this, mDBColumnsMap);
            //mListView.setAdapter(mListViewAdapter);

            //GridView animation adapter.
            final SwingBottomInAnimationAdapter animationAdapter = new SwingBottomInAnimationAdapter(mListViewAdapter, 100, 150);
            animationAdapter.setShouldAnimate(true);
            animationAdapter.setShouldAnimateFromPosition(0);
            animationAdapter.setAbsListView(mListView);
            mListView.setAdapter(animationAdapter);
            mListView.setOnItemClickListener(onItemClickListener);

            PauseOnScrollHelper scrollHelper = new PauseOnScrollHelper(mApp.getPicasso(), onScrollListener, false, true);
            mListView.setOnScrollListener(scrollHelper);

            animation.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationEnd(Animation arg0) {

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

