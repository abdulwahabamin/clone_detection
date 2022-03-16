	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		mContext =  getActivity().getApplicationContext();
		mApp = (Common) mContext;
		View rootView = (View) getActivity().getLayoutInflater().inflate(R.layout.fragment_welcome_screen_2, null);		
		
		mFoldersLayout = (RelativeLayout) rootView.findViewById(R.id.folders_fragment_holder);
		if (mApp.getSharedPreferences().getInt("MUSIC_FOLDERS_SELECTION", 0)==0) {
			mFoldersLayout.setVisibility(View.INVISIBLE);
			mFoldersLayout.setEnabled(false);
		} else {
			mFoldersLayout.setVisibility(View.VISIBLE);
			mFoldersLayout.setEnabled(true);
		}
		
		mSlideInAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, 
				  								   Animation.RELATIVE_TO_SELF, 0.0f, 
				  								   Animation.RELATIVE_TO_SELF, 2.0f, 
				  								   Animation.RELATIVE_TO_SELF, 0.0f);

		mSlideInAnimation.setDuration(600);
		mSlideInAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
		mSlideInAnimation.setAnimationListener(slideInListener);
		
		mSlideOutAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, 
				   								    Animation.RELATIVE_TO_SELF, 0.0f, 
				   								    Animation.RELATIVE_TO_SELF, 0.0f, 
				   								    Animation.RELATIVE_TO_SELF, 2.0f);
		mSlideOutAnimation.setDuration(600);
		mSlideOutAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
		mSlideOutAnimation.setAnimationListener(slideOutListener);
		
		mChildFragmentManager = this.getChildFragmentManager();
		mChildFragmentManager.beginTransaction()
	 	 					 .add(R.id.folders_fragment_holder, getMusicFoldersSelectionFragment())
	 	 					 .commit();
		
		mWelcomeHeader = (TextView) rootView.findViewById(R.id.welcome_header);
		mWelcomeHeader.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Light"));
		
        mMusicFoldersOptions = (RadioGroup) rootView.findViewById(R.id.music_library_welcome_radio_group);
        RadioButton getAllSongsRadioButton = (RadioButton) mMusicFoldersOptions.findViewById(R.id.get_all_songs_radio);
        RadioButton letMePickFoldersRadioButton = (RadioButton) mMusicFoldersOptions.findViewById(R.id.pick_folders_radio);
        
        getAllSongsRadioButton.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
        letMePickFoldersRadioButton.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
        
        mMusicFoldersOptions.setOnCheckedChangeListener(onCheckedChangeListener);
        return rootView;
    }

