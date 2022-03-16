    private static void recentlyOpenedFiles(String folder,long when) {
        for(int i=SERVICE.recentlyOpenedFiles.size()-1; i>=0; i--) {
            if(SERVICE.recentlyOpenedFiles.get(i).equals(folder))
                SERVICE.recentlyOpenedFiles.remove(i);
        }
        SERVICE.recentlyOpenedFiles.add(folder);
        if(SERVICE.recentlyOpenedFiles.size()>20)
            SERVICE.recentlyOpenedFiles.remove(0);
    }

