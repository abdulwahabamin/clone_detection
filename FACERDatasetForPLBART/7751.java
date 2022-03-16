        private boolean getList( boolean su ) {
            if( !su ) sh = "sh";
            String path = src.getPath();
            if( path == null ) {
                path = SLS;
                src = src.buildUpon().encodedPath( path ).build();
            }
            parentLink = path == null || path.length() == 0 || path.equals( SLS ) ? SLS : "..";
            array = new ArrayList<LsItem>();
            // the option -s is not supported on some releases (1.6)
            String to_execute = "ls " + ( ( mode & MODE_HIDDEN ) != HIDE_MODE ? "-a ":"" ) + "-l " + ExecEngine.prepFileName( path ) + " ; echo " + EOL;
            
            if( !execute( to_execute, false, su ? 5000 : 500 ) ) // 'busybox -l' always outs UID/GID as numbers, not names!  
                return false;   

            if( !isStopReq() ) {
                int sz = array != null ? array.size() : 0;
                items_tmp = new LsItem[sz];
                if( sz > 0 ) {
                    array.toArray( items_tmp );
                    LsItem.LsItemPropComparator comp = 
                        items_tmp[0].new LsItemPropComparator( mode & MODE_SORTING, (mode & MODE_CASE) != 0, ascending );
                    Arrays.sort( items_tmp, comp );
                }
                                
                return true;
            }
            return false;
        }

