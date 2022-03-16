        @Override
        public void doBackground() {
            ShareGroup.getAlbumArt(username, albumId, new ShareGroup.GetAlbumArtListener() {
                @Override
                public void onGotAlbumArt(File imageFile) {
                    albumArtFile = imageFile;
                    latch.countDown();
                }

                @Override
                public void onFailedGettingAlbumArt() {
                    albumArtFile = null;
                    latch.countDown();
                }
            });

            try {
                latch.await();
            } catch (InterruptedException e) {
                Log.d("doBackground()", "who dares disturb my slumber");
            }

            if (albumArtFile != null) {
                File newFile = new File(filePath);
                if(newFile.exists()) newFile.delete();
                FileInputStream fin;
                FileOutputStream fout;
                try {
                    newFile.createNewFile();
                    fin = new FileInputStream(albumArtFile);
                    fout = new FileOutputStream(newFile);
                    int length;
                    byte[] buffer = new byte[8096];
                    while((length = fin.read(buffer)) > 0) {
                        fout.write(buffer,0,length);
                    }
                    fin.close();
                    fout.close();
                    ShareGroup.deleteCacheFile(albumArtFile.getName());
                    albumArtFile = newFile;
                } catch (IOException e) {
                    if(newFile.exists()) { newFile.delete(); }
                }
            }
        }

