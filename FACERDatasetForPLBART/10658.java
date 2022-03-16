    /**
     * Method that parses and extracts the permissions from a unix string format.
     *
     * @param permissions The raw permissions
     * @return Permissions An object with all the permissions
     * @throws ParseException If the permissions can't be parsed
     * @{link "http://en.wikipedia.org/wiki/File_system_permissions"}
     */
    public static Permissions parsePermission(String permissions) throws ParseException {
        if (permissions.length() != 10) {
            throw new ParseException("permission length() != 10", 0); //$NON-NLS-1$
        }
        UserPermission up = new UserPermission(
                permissions.charAt(1) == Permission.READ,
                permissions.charAt(2) == Permission.WRITE,
                permissions.charAt(3) ==  Permission.EXECUTE
                    || permissions.charAt(3) == UserPermission.SETUID_E,
                permissions.charAt(3) == UserPermission.SETUID_E
                    || permissions.charAt(3) == UserPermission.SETUID);
        GroupPermission gp = new GroupPermission(
                permissions.charAt(4) == Permission.READ,
                permissions.charAt(5) == Permission.WRITE,
                permissions.charAt(6) == Permission.EXECUTE
                    || permissions.charAt(6) == GroupPermission.SETGID_E,
                permissions.charAt(6) == GroupPermission.SETGID_E
                    || permissions.charAt(6) == GroupPermission.SETGID);
        OthersPermission op = new OthersPermission(
                permissions.charAt(7) == Permission.READ,
                permissions.charAt(8) == Permission.WRITE,
                permissions.charAt(9) == Permission.EXECUTE
                    || permissions.charAt(9) == OthersPermission.STICKY_E,
                permissions.charAt(9) == OthersPermission.STICKY_E
                    || permissions.charAt(9) == OthersPermission.STICKY);
        return new Permissions(up, gp, op);
    }

