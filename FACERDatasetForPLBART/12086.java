    /**
     * Method that build a virtual file from a real path
     *
     * @param path The path from build the virtual file
     * @return TFile The virtual file
     */
    public String buildVirtualPath(TFile path) {
        String real = mStorageRoot.toString();
        String virtual = getVirtualMountPoint().toString();
        String dst = path.toString().replace(real, virtual);
        return dst;
    }

