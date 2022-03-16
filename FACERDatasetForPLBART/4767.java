    private static void refreshKnownPaths(String hintFilePath, long when) {
        if(hintFilePath!=null && !hintFilePath.equals("/")) {

            long start = Cal.getUnixTime();
            //BLog.e("RUNNING REFRESH for hintpath: "+hintFilePath);

            File hint = new File(hintFilePath);
            if (hint.exists()) {
                if(hint.isDirectory()) {
                    FileManagerDisk fm = new FileManagerDisk();
                    fm.setCurrentDirectory(IND.context, hintFilePath);
                    fm.readDirectory(IND.context);
                    List<FileItem> dirfiles = fm.getDirectory(IND.context);
                    int count = 0;
                    long now = (new Date()).getTime() - 120;
                    for (FileItem file : dirfiles) {
                        if (!file.isDirectory() && file.lastModified() > when) {
                            //BLog.e("NEW LASTMODIFIED DATE: "+file.getAbsolutePath());
                            indexFile(file);
                            count++;
                        } else {
                            refreshKnownPaths(hintFilePath + File.separator + file.getName(), when);
                        }
                    }
                    //BLog.e("FINISHED   ------  running REFRESH index, files: " + count);
                } else {
                    if(hint.lastModified() > when) {
                        //BLog.e("NEW LASTMODIFIED DATE: "+hint.getAbsolutePath());
                        indexFile(new FileItem(hint));
                    }
                }

            } else {
                //BLog.e( "HINT PATH NOT EXISTS: " + hintFilePath);
            }
            long end = Cal.getUnixTime();
            BLog.e("RUNNING REFRESH FINISHED: "+((end-start)/1000)+" secs");
        }
// TODO

    }

