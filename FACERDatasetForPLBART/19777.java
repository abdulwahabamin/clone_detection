  	@Override
	public void updateDrawState(TextPaint tp) {
    	tp.setTypeface(mTypeface);
     	// Note: This flag is required for proper typeface rendering
    	tp.setFlags(tp.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
	}

