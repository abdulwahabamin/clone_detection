    public final char getBoundKey() {
        switch( id ) {
        case  R.id.F1:           return  '1';
        case  R.id.F2:           return  '2';
        case  R.id.F3:           return  '3';
        case  R.id.F4:           return  '4';
        case  R.id.SF4:          return   0;
        case  R.id.F5:           return  '5';
        case  R.id.F6:           return  '6';
        case  R.id.F7:           return  '7';
        case  R.id.F8:           return  '8';
        case  R.id.F9:           return  '9';
        case  R.id.F10:          return  '0';
        case  R.id.eq:           return  '=';
        case  R.id.tgl:          return  0;
        case  R.id.sz:           return  '"';
        case  R.id.by_name:      return  0;
        case  R.id.by_ext:       return  0;
        case  R.id.by_size:      return  0;
        case  R.id.by_date:      return  0;
        case  R.id.sel_all:      return  '+';
        case  R.id.uns_all:      return  '-';
        case  R.id.enter:        return  0;
        case  R.id.add_fav:      return  '*';
        case  R.id.remount:      return  0;
        case  R.id.search:       return  '/';        
        }
        return 0;
    }

