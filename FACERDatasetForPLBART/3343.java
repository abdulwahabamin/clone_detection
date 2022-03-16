        @Override
        protected Boolean doInBackground(Boolean... params) {

            BLog.e("running process messages");
            Set<String> folders = SERVICE.checkFiles.keySet();
            BLog.e(folders.toString());
            for(String key: folders) {
                long when = SERVICE.checkFiles.get(key);
                FileItem f = new FileItem(key);
                //if(when)
                //BLog.e("INDEXING FILE: "+key);
                Indexer.indexFile(new FileItem(key));
                //Indexer.refresh(SERVICE,key,when);

            }
            for(String key: folders) {
                SERVICE.checkFiles.remove(key);
            }
            return Boolean.TRUE;

        }

