  public VisualizerView(Context context, AttributeSet attrs, int defStyle)
  {
    super(context, attrs);

    mBytes = null;
    mFFTBytes = null;

    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    type = sp.getString(VISUALIZATION_TYPE, getResources().getString(R.string.visual_none));
    
    if( type.equals(getResources().getString(R.string.visual_solidbargraph)) ){
    	
    	mRenderer = new SolidBarGraphRenderer(context);
    	
    }
    else if ( type.equals(getResources().getString(R.string.visual_waveform)) ){

        mRenderer = new WaveformRenderer(context);
    	
    }
    else if ( type.equals(getResources().getString(R.string.visual_bargraph)) ){

    	mRenderer = new BarGraphRenderer(context);
    	
    }    
    
  }

