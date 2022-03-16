    public ViewHolderGrid(View view) {
        mViewHolderImage = (ImageView)view.findViewById(R.id.gridview_image);
        mViewHolderLineOne = (TextView)view.findViewById(R.id.gridview_line_one);
        mViewHolderLineTwo = (TextView)view.findViewById(R.id.gridview_line_two);
        mPeakOne = (ImageView)view.findViewById(R.id.peak_one);
        mPeakTwo = (ImageView)view.findViewById(R.id.peak_two);
        mInfoHolder = (LinearLayout)view.findViewById(R.id.gridview_info_holder);
        mInfoHolder.setBackgroundColor(view.getResources().getColor(R.color.transparent_black));
    }

