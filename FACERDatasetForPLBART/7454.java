	public LocationBar( FileCommander c_, Panels p_, Favorites shortcuts_list ) {
		super();
		c = c_;
		p = p_;
		favorites = shortcuts_list;
		goPanel = c.findViewById( R.id.uri_edit_panel );
		
        try {
            AutoCompleteTextView textView = (AutoCompleteTextView)goPanel.findViewById( R.id.uri_edit );
            if( textView != null ) {
	            textView.setAdapter( this );
	            textView.setOnKeyListener( this );
	            textView.addTextChangedListener( this );
            }
            Button go = (Button)goPanel.findViewById( R.id.go_button );
            if( go != null ) {
            	go.setOnClickListener( this );
            }
            View star = goPanel.findViewById( R.id.star );
            if( star != null )
            	star.setOnClickListener( this );
            density = c.getContext().getResources().getDisplayMetrics().density;
        } catch( Exception e ) {
			c.showMessage( "Exception on setup history dropdown: " + e );
		}
	}

