	public boolean readDirectory(final Context context) {

		fileList = new ArrayList<FileItem>();

		int countImages=0;

        if(isZipFileOk()) {

            Enumeration<? extends ZipEntry> entries = useZipFile.entries();

            int i=0;
            String currentZipPath=File.separator;
            String currentSubPath="";
            while (entries.hasMoreElements()) {
                ZipEntry f = entries.nextElement();

                if(i!=0 && f.isDirectory())
                    currentSubPath=File.separator;


                FileItemZip fz = new FileItemZip(f.getName(), f.getSize());
                fz.subpath=currentZipPath+currentSubPath;
                if (Files.isImage(fz.getName()))
                    countImages++;
                fz.icon = Files.getFileRIcon(fz.getName());

                if(i!=0 && f.isDirectory())
                    currentSubPath=File.separator+f.getName();

                fileList.add(fz);
                i++;
            }



            //reOrderFiles(context);
        }
        return true;

	}

