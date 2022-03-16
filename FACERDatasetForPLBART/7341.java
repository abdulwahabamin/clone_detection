        /**
         *  Create a new shiny ZIP 
         */
        CopyToEngine( Handler h, File[] list, File zip_file ) {  
            super( h );
            topList = list;
            zipFile = zip_file;
            destPath = "";
            basePathLen = list.length > 0 ? list[0].getParent().length() + 1 : 0;
            newZip = true;
        }

