	@Override
	public void onClick( View v ) {
		switch( v.getId() ) {
		case R.id.star: 
			try {
				if( toChange < 0 ) break;
				TextView edit = (TextView)goPanel.findViewById( R.id.uri_edit );
	            String     uri_s = edit.getText().toString().trim();
	            CheckBox star_cb = (CheckBox)v;
                Uri u = Uri.parse( uri_s );
	            favorites.removeFromFavorites( u );
				if( star_cb.isChecked() ) {
                    if( Favorite.isPwdScreened( u ) ) {
                        Credentials crd = favorites.searchForPassword( u );
                        if( crd == null )
                            u = Favorite.borrowPassword( u, p.getFolderUriWithAuth( true ) );
                        favorites.add( new Favorite( u, crd ) );
                    }
                    else
                        favorites.add( new Favorite( u ) );
				}
				notifyDataSetChanged();
				star_cb.setChecked( favorites.findIgnoreAuth( u ) >= 0 );
				AutoCompleteTextView actv = (AutoCompleteTextView)goPanel.findViewById( R.id.uri_edit );
				actv.showDropDown();
				actv.requestFocus();
			}
			catch( Exception e ) {
			}
			break;
		case R.id.go_button:
		    applyGoPanel();
		    break;
		}
	}

