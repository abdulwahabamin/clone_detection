		@Override
		public int compare( ZipEntry f1, ZipEntry f2 ) {
            boolean f1IsDir = f1.isDirectory();
            boolean f2IsDir = f2.isDirectory();
            if( f1IsDir != f2IsDir )
                return f1IsDir ? -1 : 1;
            int ext_cmp = 0;
            switch( type ) {
            case SORT_EXT:
                ext_cmp = case_ignore ? 
                        Utils.getFileExt( f1.getName() ).compareToIgnoreCase( Utils.getFileExt( f2.getName() ) ) :
                        Utils.getFileExt( f1.getName() ).compareTo( Utils.getFileExt( f2.getName() ) );
                break;
            case SORT_SIZE:
                ext_cmp = f1.getSize() - f2.getSize() < 0 ? -1 : 1;
                break;
            case SORT_DATE:
                ext_cmp = f1.getTime() - f2.getTime() < 0 ? -1 : 1;
                break;
            }
            if( ext_cmp == 0 )
                ext_cmp = case_ignore ? f1.getName().compareToIgnoreCase( f2.getName() ) : f1.getName().compareTo( f2.getName() );
            return ascending ? ext_cmp : -ext_cmp;
		}

