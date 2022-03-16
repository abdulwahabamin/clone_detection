    /**
     * Method that parse a {@link "/proc/mounts"} line.
     *
     * @param src The mount point line
     * @return MountPoint The mount point information
     * @throws ParseException If the line can't be parsed
     */
    public static MountPoint toMountPoint(final String src) throws ParseException {

        // rootfs on / type rootfs (ro,seclabel,relatime)
        // tmpfs on /dev type tmpfs (rw,seclabel,nosuid,relatime,size=1460476k,nr_inodes=142719,mode=755)
        // devpts on /dev/pts type devpts (rw,seclabel,relatime,mode=600)
        // /dev/block/mmcblk0p14 on /system type ext4 (rw,seclabel,relatime,data=ordered)

        try {

            //Extract all the info
            String line = src;
            // Device
            int pos = line.indexOf(" "); //$NON-NLS-1$
            String device = line.substring(0, pos).trim();
            line = line.substring(pos).trim();
            // Skip "on"
            pos = line.indexOf(" "); //$NON-NLS-1$
            if ("on".equals(line.substring(0, pos).trim())) {
                line = line.substring(pos).trim();
            }
            // Mount point
            pos = line.indexOf(" "); //$NON-NLS-1$
            String mountPoint = line.substring(0, pos).trim();
            line = line.substring(pos).trim();
            // Skip "type"
            pos = line.indexOf(" "); //$NON-NLS-1$
            if ("type".equals(line.substring(0, pos).trim())) {
                line = line.substring(pos).trim();
            }
            // Type
            pos = line.indexOf(" "); //$NON-NLS-1$
            String type = line.substring(0, pos).trim();
            line = line.substring(pos).trim();
            // Options
            String options;
            if (line.charAt(0) == '(') {
                options = line.substring(1, line.length() - 1).trim();
            } else {
                options = line.trim();
            }

            //Return the mount point
            return new MountPoint(mountPoint, device, type, options, /*dump*/0, /*pass*/0, false, false);

        } catch (Exception e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

