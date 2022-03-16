        public final FileItem[] getItems( int mode ) {
            if( result == null ) return null;
            File[] files_ = new File[result.size()];
            result.toArray( files_ );
            return filesToItems( files_ );
        }       

