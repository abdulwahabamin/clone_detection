  @Override
  public void onRender(Canvas canvas, AudioData data, Rect rect)
  {
	  
    // Calculate points for line
    for (int i = 0; i < data.bytes.length - 1; i++) {
      mPoints[i * 4] = rect.width() * i / (data.bytes.length - 1);
      mPoints[i * 4 + 1] =  rect.height() / 2
          + ((byte) (data.bytes[i] + 128)) * (rect.height() / 3) / 128;
      mPoints[i * 4 + 2] = rect.width() * (i + 1) / (data.bytes.length - 1);
      mPoints[i * 4 + 3] = rect.height() / 2
          + ((byte) (data.bytes[i + 1] + 128)) * (rect.height() / 3) / 128;
    }

    // Calc amplitude for this waveform
    float accumulator = 0;
    for (int i = 0; i < data.bytes.length - 1; i++) {
      accumulator += Math.abs(data.bytes[i]);
    }
    if(MusicUtils.isPlaying()){
	    float amp = accumulator/(128 * data.bytes.length);
	    if(amp > amplitude)
	    {
	      // Amplitude is bigger than normal, make a prominent line
	    	amplitude = amp;    
	    	
	    	canvas.drawLines(mPoints, paintBrightBlur);
	    	canvas.drawLines(mPoints, mBrightPaint);
	    }
	    else
	    {
	      // Amplitude is nothing special, reduce the amplitude
	    	amplitude *= 0.99;

	    	canvas.drawLines(mPoints, paintBlur);
	    	canvas.drawLines(mPoints, mPaint);
	    }
    }
  }

