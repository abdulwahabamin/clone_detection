        protected final ZipEntry[] GetFolderList( String fld_path ) {
            if( zip == null ) return null;
            if( fld_path == null ) fld_path = ""; 
            else
                if( fld_path.length() > 0 && fld_path.charAt( 0 ) == SLC ) 
                    fld_path = fld_path.substring( 1 );                                 
            int fld_path_len = fld_path.length();
            if( fld_path_len > 0 && fld_path.charAt( fld_path_len - 1 ) != SLC ) { 
                fld_path = fld_path + SLC;
                fld_path_len++;
            }
            Enumeration<? extends ZipEntry> entries = zip.entries();
            if( entries == null )
                return null;
            ArrayList<ZipEntry> array = new ArrayList<ZipEntry>();
            while( entries.hasMoreElements() ) {
                if( isStopReq() ) return null;
                
                ZipEntry e = entries.nextElement();
                if( e != null ) {
                    String entry_name = fixName( e );
                    //Log.v( TAG, "Found an Entry: " + entry_name );
                    if( entry_name == null || fld_path.compareToIgnoreCase(entry_name) == 0 ) 
                        continue;
                    /* There are at least two kinds of zips - with dedicated folder entry and without one.
                     * The code below should process both.
                     * Do not change until you fully understand how it works.
                     */
                    if( fld_path.regionMatches( true, 0, entry_name, 0, fld_path_len ) ) {
                        int sl_pos = entry_name.indexOf( SLC, fld_path_len );
                        if( sl_pos > 0 ) {
                            String sub_dir = entry_name.substring( fld_path_len, sl_pos );
                            int    sub_dir_len = sub_dir.length();
                            boolean not_yet = true;
                            for( int i = 0; i < array.size(); i++ ) {
                                String a_name = fixName( array.get( i ) );
                                if( a_name.regionMatches( fld_path_len, sub_dir, 0, sub_dir_len ) ) {
                                    not_yet = false;
                                    break;
                                }
                            }
                            if( not_yet ) {  // a folder
                                ZipEntry sur_fld = new ZipEntry( entry_name.substring( 0, sl_pos+1 ) );
                                byte[] eb = { 1, 2 };
                                sur_fld.setExtra( eb );
                                array.add( sur_fld );
                            }
                        }
                        else
                            array.add( e ); // a leaf
                    }
                }
            }
            return array.toArray( new ZipEntry[array.size()] );
        }

