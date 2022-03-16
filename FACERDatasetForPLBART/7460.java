	@Override
	public View getView( int position, View convertView, ViewGroup parent ) {
		TextView tv = convertView != null ? (TextView)convertView : new TextView( c );
		int vp = p.fingerFriendly ? (int)( 10 * density ) : 4;
		tv.setPadding( 4, vp, 4, vp );
		String screened = favorites.get( position ).getUriString( true );
		tv.setText( screened == null ? "" : screened );
		tv.setTextColor( 0xFF000000 );
		return tv;
	}

