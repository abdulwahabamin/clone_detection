    @LargeTest
    public void testPlayAllSongs() {
      Activity mediaPlaybackActivity;
      try{
        Instrumentation inst = getInstrumentation();
        ActivityMonitor mediaPlaybackMon = inst.addMonitor("com.android.music.MediaPlaybackActivity", 
          null, false);
        inst.invokeMenuActionSync(getActivity(), MusicUtils.Defs.CHILD_MENU_BASE + 3, 0);
        Thread.sleep(MusicPlayerNames.WAIT_LONG_TIME);
        mediaPlaybackActivity = mediaPlaybackMon.waitForActivityWithTimeout(2000);
        for (int i=0;i< MusicPlayerNames.NO_SKIPPING_SONGS;i++){               
          Thread.sleep(MusicPlayerNames.SKIP_WAIT_TIME);
          if (i==0){
            //Set the repeat all
            inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_RIGHT);
            inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_UP);
            inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_CENTER);
     
            //Set focus on the next button
            inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
          }
          inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_CENTER);      
        }   
        mediaPlaybackActivity.finish();
      }catch (Exception e){
        Log.e(TAG, e.toString());
      }
      //Verification: check if it is in low memory
      ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
      ((ActivityManager)getActivity().getSystemService("activity")).getMemoryInfo(mi);
      assertFalse(TAG, mi.lowMemory);      
    }

