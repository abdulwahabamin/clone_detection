    /**
     * Constructor of <code>ShellConsole</code>.
     *
     * @param shell The shell used to execute commands
     * @throws FileNotFoundException If the initial directory not exists
     * @throws IOException If initial directory couldn't be resolved
     */
    public ShellConsole(Shell shell)
            throws FileNotFoundException, IOException {
        super();
        this.mShell = shell;
        this.mExecutableFactory = new ShellExecutableFactory(this);

        this.mBufferSize = DEFAULT_BUFFER;

        //Restart the buffers
        this.mSbIn = new ByteArrayOutputStream();
        this.mSbErr = new ByteArrayOutputStream();

        //Generate an aleatory secure random generator
        try {
            this.mRandom = SecureRandom.getInstance("SHA1PRNG"); //$NON-NLS-1$
        } catch (Exception ex) {
            throw new IOException(ex);
        }
    }

