    /**
     * Loops through the HashMap and removes the specified key and
     * all other keys that start with the specified key.
     */
    private void removeKeyAndSubFolders(String key) {
        //Get a list of all file paths (keys).
        Set<String> keySet = mFragment.getMusicFoldersHashMap().keySet();
        String[] keyArray = new String[keySet.size()];
        keySet.toArray(keyArray);

        if (keyArray==null || keyArray.length==0)
            return;

        for (int i=0; i < keyArray.length; i++)
            if (keyArray[i].startsWith(key))
                mFragment.getMusicFoldersHashMap().remove(keyArray[i]);

    }

