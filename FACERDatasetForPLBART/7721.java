        public MountItem( String string ) {
            String[] flds = string.split( " " );
            if( flds.length < 4 ) {
                dev = "???";
            }
            if( flds[1].equals( "on" ) && flds[3].equals( "type" ) ) {
                dev  = flds.length > 0 ? flds[0] : "";
                mntp = flds.length > 2 ? flds[2] : ""; 
                type = flds.length > 4 ? flds[4] : ""; 
                opts = flds.length > 5 ? flds[5] : "";
                
                if( opts.length() > 1 && opts.charAt( 0 ) == '(' && opts.charAt( opts.length()-1 ) == ')' )
                    opts = opts.substring( 1, opts.length()-1 );
            } else {
                dev  = flds.length > 0 ? flds[0] : "";
                mntp = flds.length > 1 ? flds[1] : ""; 
                type = flds.length > 2 ? flds[2] : ""; 
                opts = flds.length > 3 ? flds[3] : ""; 
                r1   = flds.length > 4 ? flds[4] : "";
                r2   = flds.length > 5 ? flds[5] : "";
            }
        }

