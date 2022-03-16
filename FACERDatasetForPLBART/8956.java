    /**
     * Constructor of <code>CompressCommand</code>. This method creates a compressed
     * file from one file.
     *
     * @param mode The compression mode
     * @param src The file to compress
     * @param asyncResultListener The partial result listener
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public CompressCommand(
            CompressionMode mode, String src, AsyncResultListener asyncResultListener)
            throws InvalidCommandDefinitionException {
        super(Mode.fromCompressionMode(mode).mId,
              asyncResultListener,
              resolveCompressArgs(mode, src));
        this.mMode = Mode.fromCompressionMode(mode);

        if (this.mMode.mMode.mArchive) {
            throw new InvalidCommandDefinitionException(
                            "Unsupported compression mode"); //$NON-NLS-1$
        }

        // Create the output file
        this.mOutFile = resolveOutputFile(mode, src);
    }

