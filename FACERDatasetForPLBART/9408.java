    public static List<Console> getVirtualConsoleForSearchPath(String path) {
        List<Console> consoles = new ArrayList<Console>();
        File dir = new File(path);
        for (VirtualMountPointConsole console : sVirtualConsoles) {
            if (FileHelper.belongsToDirectory(console.getVirtualMountPoint(), dir)) {
                // Only mount consoles can participate in the search
                if (console.isMounted()) {
                    consoles.add(console);
                }
            }
        }
        return consoles;
    }

