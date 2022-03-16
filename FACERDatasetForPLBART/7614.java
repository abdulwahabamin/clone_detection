	public final void quickSearch( char ch ) {
		CommanderAdapter a = getListAdapter( true );
		if( a != null ) {
			quickSearchBuf.append( ch );
			String s = quickSearchBuf.toString();
			showTip( s );
			
			int n = ((ListAdapter)a).getCount();
			for( int i = 1; i < n; i++ ) {
				String name = a.getItemName( i , false );
				if( name == null ) continue;
				if( s.regionMatches( true, 0, name, 0, s.length() ) ) {
					setSelection( i );
					return;
				}
			}
		}
	}

