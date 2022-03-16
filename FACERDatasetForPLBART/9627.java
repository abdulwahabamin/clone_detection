    /**
     * Method that converts the unix style octal number into a Permissions reference
     *
     * @param octalPermissions The octal permissions
     * @return Permissions An object with all the permissions
     * @throws ParseException If the permissions can't be parsed
     */
    public static Permissions fromOctalString(String octalPermissions) throws ParseException {
        int size = octalPermissions.length();
        if (size != 3 && size != 4) {
            throw new ParseException(
                    "Invalid permissions string length: !=3 or != 4", 0); //$NON-NLS-1$
        }

        // Extract the data into char
        int cc = 0;
        char b = 0;
        if (size == 4) {
            b = octalPermissions.charAt(cc);
            cc++;
        }
        char u = octalPermissions.charAt(cc);
        cc++;
        char g = octalPermissions.charAt(cc);
        cc++;
        char o = octalPermissions.charAt(cc);
        cc++;

        //Get permissions
        UserPermission user =
                new UserPermission(
                        (u & 0x04) == 0x04,
                        (u & 0x02) == 0x02,
                        (u & 0x01) == 0x01,
                        (b & 0x01) == 0x01);
        GroupPermission group =
                new GroupPermission(
                        (g & 0x04) == 0x04,
                        (g & 0x02) == 0x02,
                        (g & 0x01) == 0x01,
                        (b & 0x02) == 0x02);
        OthersPermission other =
                new OthersPermission(
                        (o & 0x04) == 0x04,
                        (o & 0x02) == 0x02,
                        (o & 0x01) == 0x01,
                        (b & 0x04) == 0x04);
        return new Permissions(user, group, other);
    }

