    public LsItem( String ls_string ) {
        Matcher m = unix.matcher( ls_string );
        if( m.matches() ) {
            try {
                if( ls_string.charAt( 0 ) == 'd' )
                    directory = true;
                if( ls_string.charAt( 0 ) == 'l' )
                    link = true;
                name = m.group( 4 );
                size = Long.parseLong( m.group( 2 ) );
                String date_s = m.group( 3 ); 
                boolean in_year = date_s.indexOf( ':' ) > 0;
                SimpleDateFormat df = in_year ? format_date_time : format_date_year;
                date = df.parse( date_s );
                if( in_year ) {
                    Calendar cal = Calendar.getInstance();
                    int cur_year = cal.get( Calendar.YEAR ) - 1900;
                    int cur_month = cal.get( Calendar.MONTH );
                    int f_month = date.getMonth();
                    if( f_month > cur_month )
                        cur_year--;
                    date.setYear( cur_year );
                }
                attr = m.group( 1 );
                //Log.v( TAG, "Item " + name + ", " + attr );
            } catch( ParseException e ) {
                e.printStackTrace();
            }
            return;
        }
        m = inet.matcher( ls_string );
        if( m.matches() ) {
            try {
                if( ls_string.charAt( 0 ) == 'd' )
                    directory = true;
                name = m.group( 4 );
                if( ls_string.charAt( 0 ) == 'l' ) {    // link
                    link = true;
                    int arr_pos = name.indexOf( " -> " );
                    if( arr_pos > 0 ) {
                        link_target_name = name.substring( arr_pos + 4 );
                        name = name.substring( 0, arr_pos );
                    }
                }
                String sz_str = m.group( 2 );
                size = sz_str != null && sz_str.length() > 0 ? Long.parseLong( sz_str ) : -1;
                String date_s = m.group( 3 ); 
                SimpleDateFormat df = format_full_date;
                date = df.parse( date_s );
                attr = m.group( 1 );
                if( attr != null ) attr = attr.trim();
            } catch( ParseException e ) {
                e.printStackTrace();
            }
            return;
        }
        m = msdos.matcher( ls_string );
        if( m.matches() ) {
            try {
                name = m.group( 3 );
                if( m.group( 2 ).equals( "<DIR>" ) )
                    directory = true;
                else
                    size = Long.parseLong( m.group( 2 ) );
                
                String date_s = m.group( 1 ); 
                SimpleDateFormat df = format_msdos_date;
                date = df.parse( date_s );
            } catch( ParseException e ) {
                e.printStackTrace();
            }
            return;
        }
        Log.e( TAG, "\nUnmatched string: " + ls_string + "\n" );
    }

