    @Override
    protected void onMeasure( int widthMeasureSpec, int heightMeasureSpec ) {
        //Log.v( TAG, "w:" + MeasureSpec.toString( widthMeasureSpec ) + " h:" + MeasureSpec.toString( heightMeasureSpec ) );
        
        panel_width = wm.getDefaultDisplay().getWidth();
        if( sxs ) {
            panel_width /= 2;
            panel_width -= 1;
        } else
            panel_width -= 4;
        int w_spec = MeasureSpec.makeMeasureSpec( panel_width, MeasureSpec.EXACTLY );
        lv.measure( w_spec, heightMeasureSpec );
        dv.measure( MeasureSpec.makeMeasureSpec( 1, MeasureSpec.EXACTLY ), heightMeasureSpec );
        rv.measure( w_spec, heightMeasureSpec );
        setMeasuredDimension( resolveSize( panel_width * 2 + 1, widthMeasureSpec ),
                              resolveSize( getSuggestedMinimumHeight(), heightMeasureSpec));
    }

