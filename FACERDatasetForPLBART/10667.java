    /**
     * Method that retrieve the raw string with the permissions.
     *
     * @param stat The terse stat data
     * @return String The raw string
     */
    private static String getTerseRawPermissions(String[] stat) {
        int cc = stat.length;
        int rawInt = Integer.parseInt(
                stat[cc - (TERSE_STAT_STRUCT_LENGTH - TERSE_STAT_STRUCT.RAW_MODE.ordinal())],16);

        // Extract the type
        char t = RegularFile.UNIX_ID;
        if (RMIHF.S_IFSOCK.mValue == (rawInt & RMIHF.S_IFSOCK.mValue)) {
            t = DomainSocket.UNIX_ID;
        } else if (RMIHF.S_IFLNK.mValue == (rawInt & RMIHF.S_IFLNK.mValue)) {
            t = Symlink.UNIX_ID;
        } else if (RMIHF.S_IFREG.mValue == (rawInt & RMIHF.S_IFREG.mValue)) {
            t = RegularFile.UNIX_ID;
        } else if (RMIHF.S_IFBLK.mValue == (rawInt & RMIHF.S_IFBLK.mValue)) {
            t = BlockDevice.UNIX_ID;
        } else if (RMIHF.S_IFDIR.mValue == (rawInt & RMIHF.S_IFDIR.mValue)) {
            t = Directory.UNIX_ID;
        } else if (RMIHF.S_IFCHR.mValue == (rawInt & RMIHF.S_IFCHR.mValue)) {
            t = CharacterDevice.UNIX_ID;
        } else if (RMIHF.S_IFIFO.mValue == (rawInt & RMIHF.S_IFIFO.mValue)) {
            t = NamedPipe.UNIX_ID;
        }

        // Extract User/Group/Others
        boolean us = RMIHF.S_ISUID.mValue == (rawInt & RMIHF.S_ISUID.mValue);
        boolean ur = RMIHF.S_IRUSR.mValue == (rawInt & RMIHF.S_IRUSR.mValue);
        boolean uw = RMIHF.S_IWUSR.mValue == (rawInt & RMIHF.S_IWUSR.mValue);
        boolean ux = RMIHF.S_IXUSR.mValue == (rawInt & RMIHF.S_IXUSR.mValue);
        boolean gs = RMIHF.S_ISGID.mValue == (rawInt & RMIHF.S_ISGID.mValue);
        boolean gr = RMIHF.S_IRGRP.mValue == (rawInt & RMIHF.S_IRGRP.mValue);
        boolean gw = RMIHF.S_IWGRP.mValue == (rawInt & RMIHF.S_IWGRP.mValue);
        boolean gx = RMIHF.S_IXGRP.mValue == (rawInt & RMIHF.S_IXGRP.mValue);
        boolean os = RMIHF.S_ISVTX.mValue == (rawInt & RMIHF.S_ISVTX.mValue);
        boolean or = RMIHF.S_IROTH.mValue == (rawInt & RMIHF.S_IROTH.mValue);
        boolean ow = RMIHF.S_IWOTH.mValue == (rawInt & RMIHF.S_IWOTH.mValue);
        boolean ox = RMIHF.S_IXOTH.mValue == (rawInt & RMIHF.S_IXOTH.mValue);

        // Build the raw string
        StringBuilder sb = new StringBuilder();
        sb.append(t);
        sb.append(ur ? Permission.READ : Permission.UNASIGNED);
        sb.append(uw ? Permission.WRITE : Permission.UNASIGNED);
        sb.append(us ? (ux ?
                           UserPermission.SETUID_E : UserPermission.SETUID)
                           : (ux ? Permission.EXECUTE : Permission.UNASIGNED));
        sb.append(gr ? Permission.READ : Permission.UNASIGNED);
        sb.append(gw ? Permission.WRITE : Permission.UNASIGNED);
        sb.append(gs ? (gx ?
                            GroupPermission.SETGID_E : GroupPermission.SETGID)
                            : (gx ? Permission.EXECUTE : Permission.UNASIGNED));
        sb.append(or ? Permission.READ : Permission.UNASIGNED);
        sb.append(ow ? Permission.WRITE : Permission.UNASIGNED);
        sb.append(os ? (ox ?
                            OthersPermission.STICKY_E : OthersPermission.STICKY)
                            : (ox ? Permission.EXECUTE : Permission.UNASIGNED));
        return sb.toString();
    }

