	@Override
	public void onCreate( Bundle bundle ) {
		super.onCreate( bundle );
		setContentView( R.layout.tblist );

        SharedPreferences shared_pref = PreferenceManager.getDefaultSharedPreferences( this );
        array.restore( shared_pref, this );	
		
		tlv = (TouchListView)getListView();
		adapter = new ToolButtonsAdapter();
		setListAdapter(adapter);
		
		tlv.setDropListener(onDrop);
		tlv.setRemoveListener(onRemove);
	}

