    protected View getView( View convertView, ViewGroup parent, Item item ) {
        View row_view = null;
        try {
            int parent_width = parent.getWidth();
            boolean recalc = dirty || parentWidth != parent_width;
            parentWidth = parent_width;
            dirty = false;
            boolean wm = (mode & MODE_WIDTH) == WIDE_MODE;
            boolean dm = ( mode & MODE_DETAILS ) == DETAILED_MODE;
            boolean ao = ( ATTR_ONLY & mode ) != 0;
            boolean current_wide = convertView != null && convertView.getId() == R.id.row_layout;
            if( convertView == null || 
        		( (  wm && !current_wide ) || 
        		  ( !wm &&  current_wide ) ) ) {
                row_view = mInflater.inflate( wm ? R.layout.row : R.layout.narrow, parent, false );
            }
            else {
                row_view = convertView;
                row_view.setBackgroundColor( 0 ); // transparent
            }
            boolean fat = ( mode & MODE_FINGERF ) == FAT_MODE;
            final int  LEFT_P = 1;
            final int RIGHT_P = 2;
            
            ImageView imgView = (ImageView)row_view.findViewById( R.id.fld_icon );
            TextView nameView =  (TextView)row_view.findViewById( R.id.fld_name );
            TextView attrView =  (TextView)row_view.findViewById( R.id.fld_attr );
            TextView dateView =  (TextView)row_view.findViewById( R.id.fld_date );
            TextView sizeView =  (TextView)row_view.findViewById( R.id.fld_size );

            float fnt_sz_rdc = font_size * 0.75f;   // reduced font size
            String name = item.name, size = "", date = "";
            if( dm ) {
            	if( item.size >= 0 )
            		size = Utils.getHumanSize( item.size );
            	final String MDHM_date_frm = "MMM dd kk:mm";
                if( item.date != null ) {
                    if( long_date ) {
                        date = getLocalDateTimeStr( item.date );
                    } else {
        	            String dateFormat;
    	            	dateFormat = item.date.getYear() + 1900 == Calendar.getInstance().get( Calendar.YEAR ) ?
    	                        MDHM_date_frm : "MMM dd yyyy ";
        	            date = (String)DateFormat.format( dateFormat, item.date );
                    }
                }
                if( recalc ) {
                    //Log.v( TAG, "recalc" );
                    if( ao ) {
                        sizeWidth = 0;
                        dateWidth = 0;
                        attrWidth = wm ? ( parent_width - icoWidth ) / 2 : parent_width - LEFT_P - RIGHT_P - icoWidth;
                    }
                    else {
                        if( dateView != null ) {
                            dateView.setTextSize( fnt_sz_rdc );
                            // dateWidth is pixels, but what's the return of measureText() ???
                            String sample_date = long_date ? "M" + getLocalDateTimeStr( new Date( -1 ) ) : MDHM_date_frm;
                            if( wm ) sample_date += "M";
                            dateWidth = (int)dateView.getPaint().measureText( sample_date );
                        }
                        if( sizeView != null ) {
                            sizeView.setTextSize( fnt_sz_rdc );
                            // sizeWidth is pixels, but what's the return of measureText() ???
                            sizeWidth = (int)sizeView.getPaint().measureText( "99999.9M" );
                        }
                        if( attrView != null ) {
                            // sizeWidth is pixels, but in what units the return of measureText() ???
                            int al = getPredictedAttributesLength();
                            if( al > 0 ) {
                                char[] dummy = new char[al];
                                Arrays.fill( dummy, 'c');
                                if( this instanceof RootAdapter ) {  // hack, redesign
                                    attrView.setTypeface( Typeface.create( "monospace", Typeface.NORMAL ) );
                                    attrView.setTextSize( fnt_sz_rdc * 0.9f );
                                }
                                else
                                    attrView.setTextSize( fnt_sz_rdc );
                                attrWidth = (int)attrView.getPaint().measureText( new String( dummy ) );
                                if( !wm ) {
                                    int remain = parent_width - sizeWidth - dateWidth - icoWidth - LEFT_P - RIGHT_P;
                                    a3r = attrWidth > remain;
                                    //Log.v( TAG, "aw=" + attrWidth + ",sl=" + remain + ",a3r=" + a3r );
                                    attrWidth = remain;
                                    if( a3r ) {
                                        attrWidth += sizeWidth + dateWidth;
                                    }
                                }
                            }
                            else
                                attrWidth = 0;
                        }
                    }
                }
            }
            if( item.sel && ck != null )
                row_view.setBackgroundColor( ck.selColor & 0xCFFFFFFF );
            int img_width = icoWidth;
            if( imgView != null ) {
                if( icoWidth > 0 ) {
                    imgView.setVisibility( View.VISIBLE );
                    imgView.setAdjustViewBounds( true );
                    boolean th_ok = false;
                    if( item.isThumbNail() && thumbnail_size_perc > 0 ) {
                        Drawable th = item.getThumbNail();
                        if( th != null ) {
                            if( !item.thumb_is_icon )
                                img_width = imgWidth;
                            imgView.setMaxWidth( img_width );
                            imgView.setImageDrawable( th );
                            th_ok = true;
                        }
                    }
                    if( !th_ok ) {
                        // when list is on its end we don't receive the idle notification!
                        if( thumbnail_size_perc > 0 && !item.no_thumb && ( mode & LIST_STATE ) == STATE_IDLE ) {
                            synchronized( this ) {
                                item.need_thumb = true;
                                notifyAll();
                            }
                        }
                        try {
                            imgView.setMaxWidth( img_width );
                            int ico_id;
                            if( item.icon_id != -1 )
                                ico_id = item.icon_id;
                            else {
                                if( item.name.equals( SLS ) || item.name.equals( PLS ) )
                                    ico_id = R.drawable.up;
                                else if( item.dir )
                                    ico_id = R.drawable.folder;
                                else
                                    ico_id = getIconId( name );
                            }
                            imgView.setImageResource( ico_id );
                        }
                        catch( OutOfMemoryError e ) {
                            Log.e( TAG, "", e );
                        }
                    }
                }
                else
                    imgView.setVisibility( View.GONE );
            }
            int fg_color = ck != null ? ( item.sel ? ck.sfgColor : ck.fgrColor ) : ctx.getResources().getColor( R.color.fgr_def );
            int fg_color_m = fg_color;
            if( item.colorCache != 0 )
                fg_color_m = item.colorCache; 
            else {
                try {
                    for( int i = 0; i < typeColors.length; i++ ) {
                        for( int j = 0; j < filePatterns[i].length; j++ ) {
                             Matcher m = filePatterns[i][j].matcher( name );
                             if( m != null && m.matches() ) {
                                 fg_color_m = typeColors[i];
                                 item.colorCache = fg_color_m;
                                 break;
                             }
                        }
                        if( fg_color_m != fg_color )
                            break;
                    }
                } catch( Exception e ) {
                    Log.e( TAG, null, e );
                }
            }
            if( nameView != null ) {
                nameView.setTextSize( font_size );
                if( wm ) {
                    nameWidth = parent_width - img_width - dateWidth - sizeWidth - attrWidth - LEFT_P - RIGHT_P;
                    if( nameWidth < 200 ) {
                        nameWidth += attrWidth; // sacrifice the attr. field 
                        attrWidth = 0;
                    }
                    nameView.setWidth( nameWidth );
                }
                nameView.setText( name != null ? name : "???" );
                nameView.setTextColor( fg_color_m );
//nameView.setBackgroundColor( 0xFFFF00FF );  // DEBUG!!!!!!
            }
            if( dateView != null ) {
                boolean vis = dm && !ao && ( dateWidth > 0 );
                dateView.setVisibility( vis ? View.VISIBLE : View.GONE );
                if( vis ) {
                    dateView.setTextSize( fnt_sz_rdc );
                    dateView.setWidth( dateWidth );
                    dateView.setText( date );
                    dateView.setTextColor( fg_color_m );
//dateView.setBackgroundColor( 0xFF00AA00 );  // DEBUG!!!!!!
                }
            }
            if( sizeView != null ) {
                boolean vis = dm && !ao && ( sizeWidth > 0 );
                sizeView.setVisibility( vis ? View.VISIBLE : View.GONE );
                if( vis ) {
                    sizeView.setTextSize( fnt_sz_rdc );
                    sizeView.setWidth( sizeWidth );
                    sizeView.setText( size );
                    sizeView.setTextColor( fg_color_m );
//sizeView.setBackgroundColor( 0xFF0000FF );  // DEBUG!!!!!!
                }
            }
            if( attrView != null ) {
                boolean vis = dm && attrWidth > 0;
                attrView.setVisibility( vis ? View.VISIBLE : View.GONE );
                if( vis) {
                    String attr_text = item.attr != null ? item.attr.trim() : "";
                    if( !wm ) {
                        //attrView.setPadding( img_width + 2, 0, 4, 0 ); // not to overlap the icon
                         {
                            RelativeLayout.LayoutParams rllp = new RelativeLayout.LayoutParams( 
                                                                   RelativeLayout.LayoutParams.WRAP_CONTENT, 
                                                                   RelativeLayout.LayoutParams.WRAP_CONTENT );
                            if( a3r ) {
                                rllp.addRule( RelativeLayout.ALIGN_PARENT_RIGHT );
                                rllp.addRule( RelativeLayout.BELOW, R.id.fld_date );
                                attrView.setGravity( 0x05 ); // RIGHT
                            } else {
                                rllp.addRule( RelativeLayout.BELOW, R.id.fld_name );
                                rllp.addRule( RelativeLayout.ALIGN_LEFT, R.id.fld_name );
                                rllp.addRule( RelativeLayout.ALIGN_TOP, R.id.fld_size );
                                attrView.setGravity( 0x03 ); // LEFT
                            }
                            attrView.setLayoutParams( rllp );
                        }
                    }
                    attrView.setWidth( attrWidth );
                    attrView.setTextSize( fnt_sz_rdc );
                    attrView.setVisibility( View.VISIBLE );
                    attrView.setText( attr_text );
                    attrView.setTextColor( fg_color_m );
                    if( this instanceof RootAdapter ) {
                        attrView.setTypeface( Typeface.create( "monospace", Typeface.NORMAL ) );
                        attrView.setTextSize( fnt_sz_rdc * 0.9f );
                    }
//attrView.setBackgroundColor( 0xFFFF0000 );  // DEBUG!!!!!!
                }
            }

            if( fat ) {
                int vp = (int)( 5 * density );
                row_view.setPadding( LEFT_P, vp, RIGHT_P, vp );
            }
            else 
                row_view.setPadding( LEFT_P, 3, RIGHT_P, 3 );
            
            row_view.setTag( null );
//Log.v( TAG, "p:" + parent_width + ",i:" + img_width + ",n:" + nameWidth + ",d:" + dateWidth + ",s:" + sizeWidth + ",a:" + attrWidth );            
        }
        catch( Exception e ) {
            Log.e( TAG, null, e ); 
        }
        return row_view;
    }

