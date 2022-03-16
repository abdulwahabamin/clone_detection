        @Override
        public int compare( LsItem f1, LsItem f2 ) {
            boolean f1IsDir = f1.isDirectory();
            boolean f2IsDir = f2.isDirectory();
            if( f1IsDir != f2IsDir )
                return f1IsDir ? -1 : 1;
            int ext_cmp = 0;
            switch( type ) {
            case CommanderAdapter.SORT_EXT:
                ext_cmp = case_ignore ? 
                        Utils.getFileExt( f1.getName() ).compareToIgnoreCase( Utils.getFileExt( f2.getName() ) ) :
                        Utils.getFileExt( f1.getName() ).compareTo( Utils.getFileExt( f2.getName() ) );
                break;
            case CommanderAdapter.SORT_SIZE:
                ext_cmp = f1.length() - f2.length() < 0 ? -1 : 1;
                break;
            case CommanderAdapter.SORT_DATE:
                ext_cmp = f1.getDate().compareTo( f2.getDate() );
                break;
            }
            if( ext_cmp == 0 )
                ext_cmp = case_ignore ? f1.getName().compareToIgnoreCase( f2.getName() ) : f1.compareTo( f2 );
            return ascending ? ext_cmp : -ext_cmp;
        }

