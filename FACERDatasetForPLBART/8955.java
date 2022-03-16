    /**
     * Constructor of <code>CompressCommand</code>. This method creates an archive-compressed
     * file from one or various file system objects.
     *
     * @param mode The compression mode
     * @param dst The absolute path of the new compress file
     * @param src An array of file system objects to compress
     * @param asyncResultListener The partial result listener
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public CompressCommand(
            CompressionMode mode, String dst, String[] src, AsyncResultListener asyncResultListener)
            throws InvalidCommandDefinitionException {
        super(Mode.fromCompressionMode(mode).mId,
              asyncResultListener,
              resolveArchiveArgs(Mode.fromCompressionMode(mode), dst));
        this.mMode = Mode.fromCompressionMode(mode);

        if (!this.mMode.mMode.mArchive) {
            throw new InvalidCommandDefinitionException(
                            "Unsupported archive mode"); //$NON-NLS-1$
        }

        //Convert the arguments from absolute to relative
        addExpandedArguments(
                convertAbsolutePathsToRelativePaths(dst, src), true);

        // Create the output file
        this.mOutFile = dst;
    }

