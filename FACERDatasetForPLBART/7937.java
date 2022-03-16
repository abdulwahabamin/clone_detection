        public LsItemPropComparator( int type_, boolean case_ignore_, boolean ascending_ ) {
            type = type_;
            case_ignore = case_ignore_ && ( type_ == CommanderAdapter.SORT_EXT || 
                                            type_ == CommanderAdapter.SORT_NAME );
            ascending = ascending_;
        }

