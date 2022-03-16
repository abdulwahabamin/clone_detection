        /**
         *  Add files to existing zip 
         */
        CopyToEngine( Handler h, File[] list, File zip_file, String dest_sub, int move_mode_ ) {
            super( h );
            topList = list;
            zipFile = zip_file;
            if( dest_sub != null )
                destPath = dest_sub.endsWith( SLS ) ? dest_sub : dest_sub + SLS;
            else
                destPath = "";
            basePathLen = list.length > 0 ? list[0].getParent().length() + 1 : 0;
            move = ( move_mode_ & MODE_MOVE ) != 0;
            del_src_dir = ( move_mode_ & CommanderAdapter.MODE_DEL_SRC_DIR ) != 0;
        }

