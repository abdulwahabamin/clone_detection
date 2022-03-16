		@Override
		protected Boolean doInBackground(Boolean... params) {

            if(packet.getInt(SearchPacket.INT_TYPE)==Files.CAT_ANY) {
                Searcher.doSearchFolderByCat(activity, packet.getInt(SearchPacket.INT_TYPE), null);
            } else {

                Searcher.doSearchShortcut(activity, packet.getInt(SearchPacket.INT_TYPE), null);

                folders = IndexerDb.getDb().getFoldersByCategory(packet.getInt(SearchPacket.INT_TYPE),0,30);
            }


			//BLog.e("FOLDERS GOT: "+folders.size());
			return Boolean.TRUE;

		}

