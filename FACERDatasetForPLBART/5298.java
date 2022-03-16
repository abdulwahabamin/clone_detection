    void mountStorage() {
        mountedDevices = FileEx.getAllStorageLocations();
        Iterator iterator = mountedDevices.keySet().iterator();
        String key = "";
        double total, used;
        while (iterator.hasNext()) {
            key = "" + iterator.next();
            fileEx.changeRootDirectory(mountedDevices.get(key).getAbsolutePath());
            storageSelectionList.add(new StorageSelection(mountedDevices.get(key).getAbsolutePath(), key));
        }
        fileEx.changeRootDirectory(dir);
        fileEx.setCurrentDir(dir);
    }

