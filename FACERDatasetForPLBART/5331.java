    void mountStorage(){
        mountedDevices=FileEx.getAllStorageLocations();
        Iterator iterator=mountedDevices.keySet().iterator();
        String key="";
        while(iterator.hasNext()){
            key=""+iterator.next();
            fileEx.changeRootDirectory(mountedDevices.get(key).getAbsolutePath());
            total=Double.parseDouble(fileEx.getTotalRootSpace().split(" ")[0]);
            used=Double.parseDouble(fileEx.getUsedRootSpace().split(" ")[0]);
            storageList.add(new Storage(key,String.format(getResources().getString(R.string.default_total_text),
                    fileEx.getTotalRootSpace()),String.format(getResources().getString(R.string.default_free_text),
                    fileEx.getFreeRootSpace()),String.format(getResources().getString(R.string.default_used_text),
                    fileEx.getUsedRootSpace()),getPercentage(total,used),mountedDevices.get(key).getAbsolutePath()));
        }
        storageAdapter=new StorageAdapter(storageList,this);
        storageDevices.setAdapter(storageAdapter);
    }

