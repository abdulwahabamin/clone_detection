    /**
     * Constructor of {@code SecureStorageDriver}
     */
    private SecureStorageDriver() {
        super(IOPoolLocator.SINGLETON, SecureStorageKeyManagerProvider.SINGLETON);
    }

