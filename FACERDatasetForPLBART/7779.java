        @Override
        protected boolean cmdDialog( OutputStreamWriter os, BufferedReader is, BufferedReader es ) { 
            try {
                String cmd = move ? " mv" : " cp -r";
                String esc_dest = prepFileName( dest );
                int num = src_full_names.length;
                double conv = 100./(double)num;
                for( int i = 0; i < num; i++ ) {
                    String full_name = src_full_names[i];
                    if( full_name == null ) continue;
                    File src_file = new File( full_name );
                    File dst_file = new File( dest, src_file.getName() );
                    String esc_dst_fn = prepFileName( dst_file.getAbsolutePath() ); 
                    String esc_src_fn = prepFileName( full_name );
                    LsItem probe_item = null;
                    if( permByDest || !move ) {
                        String probe_fn = permByDest ? esc_dst_fn : esc_src_fn;
                        String ls_cmd = "ls -l " + probe_fn;
                        outCmd( false, ls_cmd, os );
                        String str = null; 
                        while( is.ready() ) {
                            str = is.readLine();
                            if( str != null && str.trim().length() > 0 )
                                Log.v( TAG, ">>>" + str ); 
                        }
                        if( str != null )
                            probe_item = new LsItem( str ); 
                    }                    
                    String to_exec = cmd + " " + esc_src_fn + " " + esc_dest;
                    outCmd( true, to_exec, os );
                    if( procError( es ) ) return false;
                    
                    if( probe_item != null ) {
                        Permissions src_p = new Permissions( probe_item.getAttr() );
                        String chown_cmd = "chown " + src_p.generateChownString().append(" ").append( esc_dst_fn ).toString();
                        outCmd( false, chown_cmd, os );
                        String chmod_cmd = "chmod " + src_p.generateChmodString().append(" ").append( esc_dst_fn ).toString();
                        outCmd( true, chmod_cmd, os );
                    }
                    
                    if( !quiet ) sendProgress( full_name + "   ", (int)(i * conv) );
                    counter++;
                }
                return true;
            } catch( Exception e ) {
                error( e.getMessage() );
            }
            return false;
        }

