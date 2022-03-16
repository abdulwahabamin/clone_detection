        ThumbnailsThread( CommanderAdapterBase owner_, Handler h, FileItem[] list ) {
            owner = owner_;
            setName( getClass().getName() );
            thread_handler = h;
            mList = list;
            buf = new byte[100*1024];
            cr = owner.ctx.getContentResolver();
        }

