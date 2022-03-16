    public static FileItem getSuggestedZipFile(List<FileItem> files) {

        String sn="untitled";
        String smallestfolder=null;
        for(FileItem f:files) {
            if(smallestfolder==null || f.getParentFile().getAbsolutePath().length()<smallestfolder.length()) {
                smallestfolder=f.getParentFile().getAbsolutePath();
            }
        }
        if(smallestfolder!=null) {
            File f = new File(smallestfolder);
            sn=f.getName();
        } else {
            smallestfolder=Files.HOME_PATH_ZIP_FILES;
            Files.ensurePath(smallestfolder);
        }
        // ensurefile not exists
        for(int i=0; i<100; i++) {
            String testname=sn+(i==0?"":i+"");
            File f = new File(smallestfolder+File.separator+testname+".zip");
            if(!f.exists()) {
                sn=testname;
                break;
            }
        }
        return new FileItem(smallestfolder+File.separator+sn+".zip");
    }

