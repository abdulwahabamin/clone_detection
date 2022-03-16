    /**
     * Constructor of <code>UncompressCommand</code>.<br/>
     * <br/>
     * <ul>
     * <li>For archive and archive-compressed files, the file is extracted in a directory
     * of the current location of the file with the name of the file without the extension.</li>
     * <li>For compressed files, the file is extracted in the same directory in a file without
     * the extension, and the source file is deleted.</li>
     * </ul>
     *
     * @param src The archive-compressed file
     * @param dst The destination file of folder (if null this method resolve with the best
     * fit based on the src)
     * @param asyncResultListener The partial result listener
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public UncompressCommand(
            String src, String dst, AsyncResultListener asyncResultListener)
            throws InvalidCommandDefinitionException {
        super(resolveId(src), asyncResultListener, resolveArguments(src, dst));

        // Check that have a valid
        Mode mode = getMode(src);
        if (mode == null) {
            throw new InvalidCommandDefinitionException(
                            "Unsupported uncompress mode"); //$NON-NLS-1$
        }
        this.mMode = mode;

        // Retrieve information about the uncompress process
        if (dst != null) {
            this.mOutFile = dst;
        } else {
            this.mOutFile = resolveOutputFile(src);
        }
    }

