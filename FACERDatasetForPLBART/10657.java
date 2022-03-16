    /**
     * Method that parses the output of a terse stat command.<br/>
     * <br/>
     * The stat terse format is described as:<br/>
     * <br/>
     * <code/>
     *  terse format = "%n %s %b %f %u %g %D %i %h %t %T %X %Y %Z %o":
     *      filename
     *      size(bytes)
     *      blocks
     *      Raw_mode(HEX)
     *      Uid
     *      Gid
     *      Device(HEX)
     *      Inode
     *      hard_links
     *      major_device_type(HEX)
     *      minor_device_type(HEX)
     *      Access(Epoch seconds)
     *      Modify(Epoch seconds)
     *      Change(Epoch seconds)
     *      IOblock
     * </code>
     *
     * @param output Line with the output of a line of a stat command
     * @return FileSystemObject The file system object reference
     * @throws ParseException If the permissions can't be parsed
     * @{link "http://www.gnu.org/software/coreutils/manual/html_node/stat-invocation.html"}
     */
    public static FileSystemObject parseStatOutput(final String output) throws ParseException {

        try {
            // Split the terse line
            String[] data = output.split(" "); //$NON-NLS-1$
            boolean valid = true;
            try {
                getTerseStatInt(data, TERSE_STAT_STRUCT.IOBLOCK);
            } catch (Exception e) {
                valid = false;
            }
            if (valid && output.startsWith("stat:")) { //$NON-NLS-1$
                throw new ParseException(
                        String.format("Stat failed: %s", output), 0); //$NON-NLS-1$
            }
            if (valid && data.length < TERSE_STAT_STRUCT.values().length) {
                throw new ParseException(
                        String.format("Not enought data: %s", output), 0); //$NON-NLS-1$
            }

            // Parse the line
            String raw = getTerseRawPermissions(data);
            char type = raw.charAt(0);
            Permissions permissions = parsePermission(raw);
            Date lastAccessedTime = getTerseStatDate(data, TERSE_STAT_STRUCT.ACCESS);
            Date lastModifiedTime = getTerseStatDate(data, TERSE_STAT_STRUCT.MODIFY);
            Date lastChangedTime = getTerseStatDate(data, TERSE_STAT_STRUCT.CHANGE);
            int uid = getTerseStatInt(data, TERSE_STAT_STRUCT.UID);
            User user = new User(uid, AIDHelper.getNullSafeName(uid));
            int gid = getTerseStatInt(data, TERSE_STAT_STRUCT.GID);
            Group group = new Group(gid, AIDHelper.getNullSafeName(gid));
            long size = getTerseStatLong(data, TERSE_STAT_STRUCT.SIZE);
            File file = new File(getTerseStatName(data));
            String name = file.getName();
            if (name.trim().length() == 0) {
                name = FileHelper.ROOT_DIRECTORY;
            }
            String parentDir = FileHelper.getParentDir(file);

            // Create the file system object
            FileSystemObject fso =
                    createObject(
                        parentDir, type, name, null, user, group, permissions,
                        size, lastAccessedTime, lastModifiedTime, lastChangedTime);

            // Check if its a symlink
            if (type == Symlink.UNIX_ID) {
                // Extract the ref info
                Symlink symlink = (Symlink)fso;
                File refFile = file.getCanonicalFile();
                char refType = refFile.isDirectory() ? Directory.UNIX_ID : RegularFile.UNIX_ID;
                String refName = refFile.getName();
                String refParentDir = FileHelper.getParentDir(refFile);
                Date refLastModifiedTime = new Date(refFile.lastModified());
                long refSize = refFile.length();

                // Create the ref file system object
                FileSystemObject refFso =
                        createObject(
                            refParentDir, refType, refName, null, null, null, null,
                            refSize, null, refLastModifiedTime, null);

                // Update the symlink ref
                symlink.setLink(refParentDir);
                symlink.setLinkRef(refFso);
            }

            // Parsed
            return fso;

        } catch (Exception ex) {
            // Notify the exception when parsing the data
            throw new ParseException(ex.getMessage(), 0);
        }
    }

