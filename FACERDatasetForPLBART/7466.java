	@Override
	public void afterTextChanged( Editable s ) {
		try {
			TextView edit = (TextView)goPanel.findViewById( R.id.uri_edit );
			CheckBox star = (CheckBox)goPanel.findViewById( R.id.star );
			String   addr = edit.getText().toString().trim();
			Uri       uri = Uri.parse( addr );
			star.setChecked( favorites.findIgnoreAuth( uri ) >= 0 );
		}
		catch( Exception e ) {
		}
	}

