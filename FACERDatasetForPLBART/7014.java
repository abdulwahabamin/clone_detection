    private final String getGroupName( int gid ) {
        switch( gid ) {
        case     0: return "root";           /* traditional unix root user */
        case  1000: return "system";         /* system server */
        case  1001: return "radio";          /* telephony subsystem, RIL */
        case  1002: return "bluetooth";      /* bluetooth subsystem */
        case  1003: return "graphics";       /* graphics devices */
        case  1004: return "input";          /* input devices */
        case  1005: return "audio";          /* audio devices */
        case  1006: return "camera";         /* camera devices */
        case  1007: return "log";            /* log devices */
        case  1008: return "compass";        /* compass device */
        case  1009: return "mount";          /* mountd socket */
        case  1010: return "wifi";           /* wifi subsystem */
        case  1011: return "adb";            /* android debug bridge (adbd) */
        case  1012: return "install";        /* group for installing packages */
        case  1013: return "media";          /* mediaserver process */
        case  1014: return "dhcp";           /* dhcp client */
        case  1015: return "sdcard_rw";      /* external storage write access */
        case  1016: return "vpn";            /* vpn system */
        case  1017: return "keystore";       /* keystore subsystem */
        case  1018: return "usb";            /* USB devices */
        case  1019: return "drm";            /* DRM server */
        case  1020: return "available";      /* available for use */
        case  1021: return "gps";            /* GPS daemon */
        case  1023: return "media_rw";       /* internal media storage write access */
        case  1024: return "mtp";            /* MTP USB driver access */
        case  1025: return "nfc";            /* nfc subsystem */
        case  1026: return "drmrpc";         /* group for drm rpc */                    
        case  2000: return "shell";          /* adb and debug shell user */
        case  2001: return "cache";          /* cache access */
        case  2002: return "diag";           /* access to diagnostic resources */
        case  3001: return "net_bt_admin";   /* bluetooth: create any socket */
        case  3002: return "net_bt";         /* bluetooth: create sco, rfcomm or l2cap sockets */
        case  3003: return "inet";           /* can create AF_INET and AF_INET6 sockets */
        case  3004: return "net_raw";        /* can create raw INET sockets */
        case  3005: return "net_admin";
        case  9998: return "misc";           /* access to misc storage */
        case  9999: return "nobody";
        default:    return gid >= 10000 ? "app_" + ( gid - 10000 ) : "?";
        }
    }    

