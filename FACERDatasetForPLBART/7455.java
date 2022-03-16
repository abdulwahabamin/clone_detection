	public void setFingerFriendly( boolean finger_friendly, int font_size ) {
        Button go = (Button)goPanel.findViewById( R.id.go_button );
        if( go != null ) {
            int pv = 0;//go.getPaddingTop();
            int ph = finger_friendly ? 20 : 8;
            go.setPadding( ph, pv, ph, pv );
        }
	}

