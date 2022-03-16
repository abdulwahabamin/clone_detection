  	@Override
  	public void updateMeasureState(TextPaint p) {
      	p.setTypeface(mTypeface);

      	// Note: This flag is required for proper typeface rendering
      	p.setFlags(p.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
  	}

