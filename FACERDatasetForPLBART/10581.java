    /**
     * Method that returns is a {@link FileSystemObject} can be handled by this application
     * allowing the uncompression of the file
     *
     * @param fso The file system object to verify
     * @return boolean If the file is supported
     */
    @SuppressWarnings("nls")
    public static boolean isSupportedUncompressedFile(FileSystemObject fso) {
        // Valid uncompressed formats are:
        final String[] VALID =
                {
                    "tar", "tgz", "tar.gz", "tar.bz2", "tar.lzma",
                    "zip", "gz", "bz2", "lzma", "xz", "Z", "rar"
                };
        // Null values for required commands
        final String[] OPT_KEYS =
                {
                    null, null, null, null, null,
                    "unzip", null, null, "unlzma", "unxz", "uncompress", "unrar"
                };

        // Check that have a valid file
        if (fso == null) return false;

        // Only regular files
        if (isDirectory(fso) || fso instanceof Symlink) {
            return false;
        }
        // No in virtual filesystems
        if (fso.isSecure() || fso.isRemote()) {
            return false;
        }
        String ext = getExtension(fso);
        if (ext != null) {
            int cc = VALID.length;
            for (int i = 0; i < cc; i++) {
                if (VALID[i].compareToIgnoreCase(ext) == 0) {
                    // Is the command present
                    if (OPT_KEYS[i] != null &&
                        FileManagerApplication.hasOptionalCommand(OPT_KEYS[i])) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

