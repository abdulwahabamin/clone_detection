    private int setFileImageType(File m_file)
    {
        int m_lastIndex=m_file.getAbsolutePath().lastIndexOf(".");
        String m_filepath=m_file.getAbsolutePath();
        if (m_file.isDirectory())
            return R.drawable.ic_folder_black_50dp;
        else
        {
           if(m_filepath!=null && m_filepath.contains(".")) {
               if (m_filepath.substring(m_lastIndex).equalsIgnoreCase(".png")) {
                   return R.drawable.ic_insert_drive_file_black_50dp;
               } else if (m_filepath.substring(m_lastIndex).equalsIgnoreCase(".jpg")) {
                   return R.drawable.ic_insert_drive_file_black_50dp;
               }
           }else {
               return R.drawable.ic_insert_drive_file_black_50dp;
           }
        }
        return R.drawable.ic_insert_drive_file_black_50dp;
    }

