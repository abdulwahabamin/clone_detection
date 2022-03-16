    public final void applyGoPanel() {
    	closeGoPanel();
		TextView edit = (TextView)goPanel.findViewById( R.id.uri_edit );
		String new_dir = edit.getText().toString().trim();
		if( toChange >= 0 && new_dir.length() > 0 ) {
            Uri u = Uri.parse( new_dir );
            Credentials crd = null;
            if( Favorite.isPwdScreened( u ) ) {
                crd = favorites.searchForPassword( u );
            } else {
                String user_info = u.getUserInfo();
                if( Utils.str( user_info ) )
                    crd = new Credentials( user_info );
            }
            u = Utils.updateUserInfo( u, null );
			if( toChange != p.getCurrent() )
				p.togglePanels( false );
			p.Navigate( toChange, u, crd, null );
		}
		toChange = -1;
		p.focus();
    }    

