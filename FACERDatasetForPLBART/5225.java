    boolean isImage(String name){
        String ext= MimeTypeMap.getFileExtensionFromUrl(name);
        for(String img:IMG){
            if(ext.equalsIgnoreCase(img))
                return true;
        }
        return false;
    }

