    @Override
    public void openItem( int position ) {
        if( position == 0 ) {
            if( parentLink == SLS ) 
                commander.Navigate( Uri.parse( HomeAdapter.DEFAULT_LOC ), null, null );
            else {
                if( dirName == null ) return;
                File cur_dir_file = new File( dirName );
                String parent_dir = cur_dir_file.getParent();
                commander.Navigate( Uri.parse( Utils.escapePath( parent_dir != null ? parent_dir : DEFAULT_DIR ) ), null,
                                    cur_dir_file.getName() );
            }
        }
        else {
            File file = items[position - 1].f;
            if( file == null ) return;
            Uri open_uri = Uri.parse( Utils.escapePath( file.getAbsolutePath() ) );
            if( file.isDirectory() )
                commander.Navigate( open_uri, null, null );
            else
                commander.Open( open_uri, null );
        }
    }

