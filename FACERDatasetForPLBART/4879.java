    public boolean exists() {
        File f = new File(path+ File.separator+filename);
        //BLog.e("FILE",f.exists()+" : "+f.canRead()+" - "+f.canWrite()+ " - "+f.length());
        if(f.exists()) {
            //f=null;
            return true;
        }
        return false;
    }

