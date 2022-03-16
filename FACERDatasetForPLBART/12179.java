    /**
     * Method that register all the implemented virtual consoles. This method should
     * be called only once on the application instantiation.
     *
     * @param context The current context
     */
    public static void registerVirtualConsoles(Context context) {
        if (sVirtualConsoles != null) return;
        sVirtualConsoles = new ArrayList<VirtualMountPointConsole>();
        sVirtualIdentity = AIDHelper.createVirtualIdentity();
        sVirtualFolderPermissions = Permissions.createDefaultFolderPermissions();

        int bufferSize = context.getResources().getInteger(R.integer.buffer_size);

        // Register every known virtual mountable console
        sVirtualConsoles.add(SecureConsole.getInstance(context, bufferSize));
        // TODO Add remote consoles. Not ready for now.
        // sVirtualConsoles.add(new RemoteConsole(context));
    }

