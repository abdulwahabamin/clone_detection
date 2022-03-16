	public TouchListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
		
		if (attrs!=null) {
			TypedArray a=getContext().obtainStyledAttributes(attrs, R.styleable.TouchListView, 0, 0);
		
			mItemHeightNormal=a.getDimensionPixelSize(R.styleable.TouchListView_normal_height, 0);
			mItemHeightExpanded=a.getDimensionPixelSize(R.styleable.TouchListView_expanded_height, mItemHeightNormal);
			grabberId=a.getResourceId(R.styleable.TouchListView_grabber, -1);
			dragndropBackgroundColor=a.getColor(R.styleable.TouchListView_dragndrop_background, 0x00000000);
			mRemoveMode=a.getInt(R.styleable.TouchListView_remove_mode, -1);
			
			a.recycle();
		}
  }

