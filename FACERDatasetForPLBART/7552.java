    public Panels( FileCommander c_, boolean sxs_ ) {
        c = c_;
        ck = new ColorsKeeper( c );
        current = LEFT;
        c.setContentView( R.layout.alt );
        mainView = c.findViewById( R.id.main );
        
        hsv = (HorizontalScrollView)c.findViewById( R.id.hrz_scroll );
        hsv.setHorizontalScrollBarEnabled( false );
        hsv.setSmoothScrollingEnabled( true );
        hsv.setOnTouchListener( this );
        final int GINGERBREAD = 9;
        if( android.os.Build.VERSION.SDK_INT >= GINGERBREAD )
            ForwardCompat.disableOverScroll( hsv );
        
        panelsView = ((PanelsView)c.findViewById( R.id.panels ));
        panelsView.init( c.getWindowManager() );
        initList( LEFT );
        initList( RIGHT );

        favorites   = new Favorites( c );
        locationBar = new LocationBar( c, this, favorites );
        
        setLayoutMode( sxs_ );
//        highlightCurrentTitle();
        
        TextView left_title = (TextView)c.findViewById( titlesIds[LEFT] );
        if( left_title != null ) {
            left_title.setOnClickListener( this );
            left_title.setOnLongClickListener( this );
        }
        TextView right_title = (TextView)c.findViewById( titlesIds[RIGHT] );
        if( right_title != null ) {
            right_title.setOnClickListener( this );
            right_title.setOnLongClickListener( this );
        }
        try{ 
	        quickSearchBuf = new StringBuffer();
	        quickSearchTip = Toast.makeText( c, "", Toast.LENGTH_SHORT );
        }
        catch( Exception e ) {
			c.showMessage( "Exception on creating quickSearchTip: " + e );
		}
        focus();
    }

