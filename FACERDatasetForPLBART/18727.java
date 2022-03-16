        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch(item.getItemId()) {
                case R.id.play:
                    int fileIndex;
                    String folderPath;
                    if (mItemType==FilesFoldersFragment.AUDIO_FILE) {
                        fileIndex = 0;
                        folderPath = FilesFoldersFragment.currentDir;
                        for (int i=0; i < mItemPosition; i++) {
                            if (mFileFolderTypeList.get(i)==FilesFoldersFragment.AUDIO_FILE)
                                fileIndex++;
                        }

                    } else {
                        fileIndex = 0;
                        folderPath = mItemPath;
                    }

                    mFragment.play(mItemType, fileIndex, folderPath);
                    break;
                case R.id.rename:
                    mFragment.rename(mItemPath);
                    break;
                case R.id.copy:
                    mFragment.copyMove(mItemPath, false);
                    break;
                case R.id.move:
                    mFragment.copyMove(mItemPath, true);
                    break;
                case R.id.delete:
                    mFragment.deleteFile(new File(mItemPath));
                    break;
            }

            return false;
        }

