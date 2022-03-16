	public ActionBar(Context context, AttributeSet attrs) {
		super(context, attrs);

		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		RelativeLayout barView = (RelativeLayout) mInflater.inflate(R.layout.actionbar, null);
		addView(barView);

		mLogoView = (ImageView) barView.findViewById(R.id.actionbar_home_logo);
		mProgress = (ProgressBar) barView.findViewById(R.id.actionbar_progress);
		mTitleView = (TextView) barView.findViewById(R.id.actionbar_title);
		mActionIconContainer = (LinearLayout) barView.findViewById(R.id.actionbar_actionIcons);
	}

