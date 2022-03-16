    String getFileSize(int p_pos){
        File m_file=new File(m_path.get(p_pos));
        String filesize="";
        filesize=getFileSize(m_file);
        return filesize;
    }

