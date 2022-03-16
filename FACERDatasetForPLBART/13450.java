    /**
     * Method that parse a disk usage line.
     *
     * @param src The disk usage line
     * @return DiskUsage The disk usage information
     * @throws ParseException If the line can't be parsed
     */
    public static DiskUsage toDiskUsage(final String src) throws ParseException {

        // Filesystem            Size  Used Avail Use% Mounted on
        // tmpfs                 1.3G   88K  1.3G   1% /dev
        // tmpfs                 1.3G     0  1.3G   0% /mnt
        // /dev/block/mmcblk0p14 1.2G  966M  337M  75% /system
        // /dev/fuse              55G   18G   37G  34% /storage/emulated

        try {
            final int fields = 6;

            //Permission denied or invalid statistics
            if (src.indexOf(":") != -1) { //$NON-NLS-1$
                throw new ParseException(String.format("Non allowed: %s", src), 0); //$NON-NLS-1$
            }

            //Extract all the info
            String line = src;
            String[] data = new String[fields];
            for (int i = 0; i < fields; i++) {
                int pos = line.indexOf(" "); //$NON-NLS-1$
                data[i] = line.substring(0, pos != -1 ? pos : line.length());
                if (pos != -1) {
                    line = line.substring(pos).trim();
                }
            }

            //Return the disk usage
            return new DiskUsage(data[5], toBytes(data[1]), toBytes(data[2]), toBytes(data[3]));

        } catch (Exception e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

