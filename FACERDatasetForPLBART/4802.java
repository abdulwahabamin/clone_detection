    public FileItem getAsFileItem() {
        //if(getInt(INT_ICONTYPE)==0)
            return new FileItem(getString(STRING_FILEPATH)+File.separator+getString(STRING_FILENAME));
        //else
            //return new FileItem(getString(STRING_FILEPATH)+File.separator+getString(STRING_FILENAME),getInt(INT_ICONTYPE));
    }

