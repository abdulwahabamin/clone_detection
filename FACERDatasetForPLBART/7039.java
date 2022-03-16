    public final static int getSuitableAdapter( int cmd_id ) {
        switch( cmd_id ) {
        case  R.id.F1:           return  CA.ALL;
        case  R.id.F2:           return  CA.REAL | CA.FAVS;
        case  R.id.F3:           return  CA.REAL;
        case  R.id.F4:           return  CA.REAL & ~CA.ARCH | CA.FAVS;
        case  R.id.SF4:          return  CA.FS;
        case  R.id.F5:           return  CA.REAL | CA.APPS;
        case  R.id.F6:           return  CA.REAL;
        case  R.id.F7:           return  CA.REAL & ~CA.FIND | CA.MNT;
        case  R.id.F8:           return  CA.REAL | CA.FAVS | CA.APPS;
        case  R.id.F9:           return  CA.ALL;
        case  R.id.F10:          return  CA.ALL;
        case  R.id.eq:           return  CA.ALL;
        case  R.id.tgl:          return  CA.ALL;
        case  R.id.sz:           return  CA.LOCAL | CA.ROOT | CA.APPS | CA.SMB;
        case  R.id.by_name:      return  CA.REAL | CA.APPS | CA.FAVS;
        case  R.id.by_ext:       return  CA.REAL | CA.APPS | CA.FAVS;
        case  R.id.by_size:      return  CA.REAL | CA.APPS | CA.FAVS;
        case  R.id.by_date:      return  CA.REAL | CA.APPS;
        case  R.id.sel_all:      return  CA.REAL | CA.APPS;
        case  R.id.uns_all:      return  CA.REAL | CA.APPS;
        case  R.id.enter:        return  CA.ALL;
        case  R.id.add_fav:      return  CA.ALL;
        case  R.id.remount:      return  CA.ROOT;
        case  R.id.home:         return  CA.ALL & ~CA.HOME;
        case  R.id.favs:         return  CA.ALL & ~CA.FAVS;
        case  R.id.sdcard:       return  CA.ALL;
        case  R.id.root:         return  CA.ALL & ~CA.ROOT;
        case  R.id.mount:        return  CA.ROOT | CA.NAV;
        case  R.id.hidden:       return  CA.REAL;
        case  R.id.refresh:      return  CA.REAL | CA.FAVS;
        case  R.id.softkbd:      return  CA.ALL;
        case  R.id.search:       return  CA.LOCAL;
        }
        return 0;
    }

