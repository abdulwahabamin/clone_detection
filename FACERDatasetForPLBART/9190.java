    /**
     * Method that resolves the arguments for the uncompression
     *
     * @param src The source file
     * @param dst The destination file
     * @return String[] The arguments
     */
    private static String[] resolveArguments(String src, String dst) {
        String out = dst;
        if (out == null) {
            out = resolveOutputFile(src);
        }
        Mode mode = getMode(src);
        if (mode != null) {
            switch (mode) {
                case A_UNTAR:
                case AC_GUNZIP:
                case AC_GUNZIP2:
                case AC_BUNZIP:
                case AC_UNLZMA:
                    return new String[]{mode.mFlag, out, src};

                case A_UNZIP:
                case A_UNRAR:
                    return new String[]{out, src};

                case C_GUNZIP:
                case C_BUNZIP:
                case C_UNLZMA:
                case C_UNCOMPRESS:
                case C_UNXZ:
                    return new String[]{src};

                default:
                    break;
            }
        }
        return new String[]{};
    }

