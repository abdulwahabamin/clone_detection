	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		mContext = getActivity().getApplicationContext();
		mApp = (Common) mContext;
		mRootView = (View) getActivity().getLayoutInflater().inflate(R.layout.fragment_building_library_progress, null);
		
		mProgressElementsContainer = (RelativeLayout) mRootView.findViewById(R.id.progress_elements_container);
		mProgressElementsContainer.setVisibility(View.INVISIBLE);
		
		mCurrentTaskText = (TextView) mRootView.findViewById(R.id.building_library_task);
		mCurrentTaskText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Light"));
        mCurrentTaskText.setPaintFlags(mCurrentTaskText.getPaintFlags() 
        						       | Paint.ANTI_ALIAS_FLAG
        						       | Paint.SUBPIXEL_TEXT_FLAG);
        
        mProgressBar = (ProgressBar) mRootView.findViewById(R.id.building_library_progress);
        mProgressBar.setMax(1000000); 
        
        mFadeInAnimation = AnimationUtils.loadAnimation(mContext, R.anim.fade_in);
        mFadeInAnimation.setAnimationListener(fadeInListener);
        mFadeInAnimation.setDuration(700);
        
        return mRootView;
    }

