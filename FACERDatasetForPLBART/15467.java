    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View view = super.getView(position, convertView, parent);

        Cursor mCursor = (Cursor) getItem(position);
        setupViewData(mCursor);

        final ViewHolderList viewholder;
        if ( view != null ) {
            viewholder = new ViewHolderList(view);
            holderReference = new WeakReference<ViewHolderList>(viewholder);
            view.setTag(holderReference.get());
        } else {
            viewholder = (ViewHolderList)convertView.getTag();
        }

        if( mLineOneText != null ){
            holderReference.get().mViewHolderLineOne.setText(mLineOneText);
        }
        else{
        	holderReference.get().mViewHolderLineOne.setVisibility(View.GONE);
        }

        if( mLineTwoText != null ){
            holderReference.get().mViewHolderLineTwo.setText(mLineTwoText);
        }
        else{
            holderReference.get().mViewHolderLineOne.setPadding(left, top, 0, 0);
            holderReference.get().mViewHolderLineTwo.setVisibility(View.GONE);
        }
        
        if( mImageData != null ){

            ImageInfo mInfo = new ImageInfo();
            mInfo.type = mListType;
            mInfo.size = SIZE_THUMB;
            mInfo.source = SRC_FIRST_AVAILABLE;
            mInfo.data = mImageData;
            
            mImageProvider.loadImage( viewholder.mViewHolderImage, mInfo ); 
        }
        else{
            holderReference.get().mViewHolderImage.setVisibility(View.GONE);
        }
        
        if( showContextEnabled ){
            holderReference.get().mQuickContext.setOnClickListener(showContextMenu);        	
        }
        else{
        	 holderReference.get().mQuickContext.setVisibility(View.GONE);
        }

        if ( ( mPlayingId !=0 && mCurrentId !=0 ) && mPlayingId ==  mCurrentId ) {
            holderReference.get().mPeakOne.setImageResource(R.anim.peak_meter_1);
            holderReference.get().mPeakTwo.setImageResource(R.anim.peak_meter_2);
            mPeakOneAnimation = (AnimationDrawable)holderReference.get().mPeakOne.getDrawable();
            mPeakTwoAnimation = (AnimationDrawable)holderReference.get().mPeakTwo.getDrawable();
            try {
                if ( MusicUtils.mService.isPlaying() ) {
                    mPeakOneAnimation.start();
                    mPeakTwoAnimation.start();
                } else {
                    mPeakOneAnimation.stop();
                    mPeakTwoAnimation.stop();
                }
            } catch ( RemoteException e ) {
                e.printStackTrace();
            }
        } else {
            holderReference.get().mPeakOne.setImageResource(0);
            holderReference.get().mPeakTwo.setImageResource(0);
        }
        return view;
    }

