    /**
     * Method that build a real file from a virtual path
     *
     * @param path The path from build the real file
     * @return TFile The real file
     */
    public TFile buildRealFile(String path) {
        String real = mStorageRoot.toString();
        String virtual = getVirtualMountPoint().toString();
        String src = path.replace(virtual, real);
        return new TFile(src, DETECTOR);
    }

