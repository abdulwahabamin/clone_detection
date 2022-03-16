    public static int getImageResIdFromExension(String name){
        String ext= MimeTypeMap.getFileExtensionFromUrl(name.replace(" ",""));
        switch (ext.toLowerCase()){
            case PDF:
                return R.drawable.pdf;

            case ZIP:
                return R.drawable.zip;

            case MP3:
            case acc:
            case aax:
            case m4a:
            case wav:
            case ogg:
            case webm:
                return R.drawable.music;

            case MP4:
            case FLV:
            case _3GP:
                return R.drawable.video;

        }
        return R.drawable.file;
    }

