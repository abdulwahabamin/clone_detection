    @Override
    public void closeStream( Closeable s ) {
        if( s instanceof FileOutputStream ) {
            if( tmp_f == null || dst_f == null ) return;
            
            CopyToEngine cte = new CopyToEngine( ctx, workerHandler, new String[] { tmp_f.getAbsolutePath() },
                    true, dst_f.getParent(), true );
            cte.setPermByDest();
            worker = cte;
            worker.start();
            return;
        }
        if( contentEngine != null ) {
            contentEngine.close();
            contentEngine = null;
        }
    }

