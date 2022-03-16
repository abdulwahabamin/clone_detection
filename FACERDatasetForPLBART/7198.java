    protected FileItem[] filesToItems( File[] files_ ) {
        int num_files = files_.length;
        int num = num_files;
        boolean hide = ( mode & MODE_HIDDEN ) == HIDE_MODE;
        if( hide ) {
            int cnt = 0;
            for( int i = 0; i < num_files; i++ )
                if( !files_[i].isHidden() ) cnt++;
            num = cnt;
        }
        FileItem[] items_ = new FileItem[num];
        int j = 0;
        for( int i = 0; i < num_files; i++ ) {
            if( !hide || !files_[i].isHidden() ) {
                FileItem file_ex = new FileItem( files_[i] );
                items_[j++] = file_ex;
            }
        }
        reSort( items_ );
        return items_;
    }

