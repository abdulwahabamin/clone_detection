    private final void calcWidths() {
        try {
            if( ( mode & ICON_MODE ) == ICON_MODE ) {
                icoWidth = (int)( density * ICON_SIZE );
                if( ( ICON_TINY & mode ) != 0 )
                    icoWidth >>= 1;
            } else
                icoWidth = 0;
            imgWidth = thumbnail_size_perc > 0 && thumbnail_size_perc != 100 ? icoWidth * thumbnail_size_perc / 100 : icoWidth;
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }

