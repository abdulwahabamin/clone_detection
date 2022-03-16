      private void rescanSdcard() throws Exception{     
        Intent scanIntent = new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://"
             + Environment.getExternalStorageDirectory()));    
        Log.v(TAG,"start the intent");
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_MEDIA_SCANNER_STARTED);
        intentFilter.addDataScheme("file");     
        getActivity().sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://"
            + Environment.getExternalStorageDirectory())));    
          Thread.sleep(MusicPlayerNames.WAIT_VERY_LONG_TIME);
      }

