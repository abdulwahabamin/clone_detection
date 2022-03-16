    /**
     * Constructor of <code>MountPoint</code>.
     *
     * @param mountPoint The mount point of the file system device
     * @param device The file system device
     * @param type The type of file system
     * @param options The mount options
     * @param dump The frequency to determine if the filesystem need to be dumped
     * @param pass The order in which filesystem checks are done at reboot time
     * @param secure If the device is a secure virtual filesystem
     * @param remote If the device is a remote virtual filesystem
     */
    public MountPoint(
            String mountPoint, String device, String type, String options, int dump,
            int pass, boolean secure, boolean remote) {
        super();
        this.mMountPoint = mountPoint;
        this.mDevice = device;
        this.mType = type;
        this.mOptions = options;
        this.mDump = dump;
        this.mPass = pass;
        this.mSecure = secure;
        this.mRemote = remote;
    }

