    public final void setToolbarButtons( CommanderAdapter ca ) {
        try {
            if( ca == null ) return;
            if( toolbarShown ) {
                if( toolbar == null ) {
                    LayoutInflater inflater = (LayoutInflater)c.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                    toolbar = inflater.inflate( R.layout.toolbar, (ViewGroup)mainView, true ).findViewById( R.id.toolbar );
                }
                if( toolbar == null ) {
                    Log.e( TAG, "Toolbar inflation has failed!" );
                    return;
                }
                toolbar.setVisibility( View.INVISIBLE );
                
                ViewGroup tb_holder = (ViewGroup)toolbar; 
                tb_holder.removeAllViews();
                /*
                if( btnColor == 0x00000000 ) {
                    tb_holder.layout( l, t, r, b )
                }
                */
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences( c );
                 
                boolean keyboard = sharedPref.getBoolean( "show_hotkeys", true ) || 
                                c.getResources().getConfiguration().keyboard != Configuration.KEYBOARD_NOKEYS ;

                Utils.changeLanguage( c );
                ToolButtons tba = new ToolButtons();
                tba.restore( sharedPref, c );
                int adapter_bit = ca.getType();
                int bfs = fnt_sz + ( fingerFriendly ? 2 : 1 );
                for( int i = 0; i < tba.size(); i++ ) {
                    ToolButton tb = tba.get(i);
                    int bid = tb.getId();
                    if( tb.isVisible() && ( adapter_bit & tb.getSuitableAdapter() ) != 0 ) {
                        LinearLayout.LayoutParams lllp = new LinearLayout.LayoutParams( 
                                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT );
                        Button b = null;
                        if( ck.btnColor != 0x00000000 ) {
                            b = new Button( c, null, android.R.attr.buttonStyleSmall );
                            int vp = fingerFriendly ? 10 : 6;
                            b.setPadding( 6, vp, 6, vp );
                            float bbb = Utils.getBrightness( ck.btnColor );
                            b.setTextColor( bbb > 0.8f ? 0xFF000000 : 0xFFFFFFFF );
                            b.setTextSize( bfs );
                            Drawable bd = createButtonStates();
                            if( bd != null )
                                b.setBackgroundDrawable( bd );
                            else
                                b.setBackgroundResource( R.drawable.tool_button );
                            lllp.rightMargin = 2;
                        }
                        else {
                            b = new Button( c, null, fingerFriendly ?         
                                      android.R.attr.buttonStyle :                     
                                      android.R.attr.buttonStyleSmall );
                            lllp.rightMargin = -2;  // a button has invisible background around it
                        }
                        b.setLayoutParams( lllp );
                        
                        b.setId( bid );
                        b.setFocusable( false );
                        String caption = "";
                        if( keyboard ) {
                            char ch = tb.getBoundKey();
                            if( ch != 0 )
                                caption = ch + " "; 
                        }
                        b.setText( caption += tb.getCaption() );
                        b.setOnClickListener( c );
                        tb_holder.addView( b );
                    }
                }
                toolbar.setVisibility( View.VISIBLE );
            }
            else {
                if( toolbar != null )
                    toolbar.setVisibility( View.GONE );
            }
        } catch( Exception e ) {
            Log.e( TAG, "setToolbarButtons() exception", e );
        }
    }

