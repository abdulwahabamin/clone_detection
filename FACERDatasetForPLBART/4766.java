    private static int runFolderIndex(String folder,int pauseMillis) {
        //Log.e("INDS","running FULL index");
        //Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
        clearCounts();
        FileManagerDisk fm = null;
        if(folder==null)
            fm=new FileManagerDisk();
        else
            fm=new FileManagerDisk(folder);

        //fm.readDirectory(IND.context);
        List<String> rawfiles=fm.getRawDirectory();

        //List<FileItem> rootfiles = new ArrayList<>();//fm.getDirectory(IND.context);
        for(String raw: rawfiles) {
            FileItem rfile = new FileItem(fm.getPath()+File.separator+raw);
            if(rfile.getAbsoluteFile().isDirectory()) {
                IND.indexdirs.add(rfile);
            }  else {
                count = count+indexFile(rfile);
                count++;
            }
        }

        //Log.e("INDS","root, dir: "+IND.indexdirs.size()+" -- file counted: "+count);
        while(!IND.indexdirs.isEmpty()) {
            FileItem fi=IND.indexdirs.get(0);
            try {
                clearCounts();
                fm.setCurrentDirectory(IND.context, fi.getAbsolutePath());
                fm.readDirectory(IND.context);

                countImages = countDocs = countMusic = countVideo =countText = 0;

                List<FileItem> dirfiles = fm.getDirectory(IND.context);
                for (FileItem rfile : dirfiles) {

                    if (rfile.getAbsoluteFile().isDirectory()) {
                        IND.indexdirs.add(rfile);
                    } else {
                        try {
                            Indexer.class.wait(pauseMillis);
                        } catch(Exception e) {}
                        int didindex = indexFile(rfile);
                        if(didindex>0) {
                            count++;
                            int iconfile = Files.getFileRIcon(rfile.getAbsolutePath());
                            int category = getCategory(iconfile,rfile.getName());
                            if(category == Files.CAT_DOCUMENT)
                                countDocs++;
                            else if(category == Files.CAT_IMAGE)
                                countImages++;
                            else if(category == Files.CAT_TEXTFILE)
                                countText++;
                            else if(category==Files.CAT_VIDEO)
                                countVideo++;
                            else if(category==Files.CAT_SOUND)
                                countMusic++;

                        }
                        //count++;
                    }

                }

                int totals = countDocs+countImages+countText+countVideo+countMusic;

                if(count>0 && (100/count)*totals>49) {

                    final HashMap<Integer,Integer> sortme=new HashMap<Integer,Integer>();
                    sortme.put(countDocs,Files.CAT_DOCUMENT);
                    sortme.put(countImages,Files.CAT_IMAGE);
                    sortme.put(countText,Files.CAT_TEXTFILE);
                    sortme.put(countVideo,Files.CAT_VIDEO);
                    sortme.put(countMusic, Files.CAT_SOUND);



                    Object[] briefsSorted= new TreeSet<Integer>(sortme.keySet()).descendingSet().toArray();



                    int usecat =sortme.get(briefsSorted[0]);
                    IndexerFile ifile = new IndexerFile(fi.getName(),fi.getParentFile().getAbsolutePath());
                    ifile.setInt(IndexerFile.INT_BOOL_ISFOLDER, 1);
                    ifile.setInt(IndexerFile.INT_CATEGORY, usecat);
                    //BLog.e("add FOLDER : " + ifile.toString());
                    if(!IndexerDb.has(fi.getName(), fi.getParentFile().getAbsolutePath())) {
                        //Log.e("INDS", "add file: " + fit.toString() + " -- " + fit.icon);
                        IndexerDb.add(ifile);
                    } else {

                        IndexerDb.update(ifile);
                    }
                    try {
                        Indexer.class.wait(pauseMillis);
                    } catch(Exception e) {}
                }

            } catch(Exception e) {
                BLog.e("EXCEPTION", "!!!!!!!!!!!!!!!!!!  EXCEPTION: " + e.getMessage());
            }
            IND.indexdirs.remove(0);
        }
        Log.e("INDS","FINISHED   ------  running FULL index, total files: "+count);

        return count;
    }

