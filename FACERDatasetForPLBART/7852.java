    ToolButton( int id_ ) {
        id = id_;
        codename = getCodeName( id_ );
        
        def_caption_r_id = getCaptionRId( id_ );
        caption = null;
        modified = false;
        visible = getVisibleDefault( id_ );
    }

