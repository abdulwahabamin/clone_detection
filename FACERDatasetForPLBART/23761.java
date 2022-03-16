    @LargeTest
    public void testAlbumPlay() { 
      Instrumentation inst = getInstrumentation();
      try{
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_RIGHT);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_RIGHT);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_CENTER);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_CENTER);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_CENTER);
        Thread.sleep(MusicPlayerNames.WAIT_LONG_TIME);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);     
        for(int i=0; i< MusicPlayerNames.NO_ALBUMS_TOBE_PLAYED; i++){
          inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
          inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_CENTER);
          inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_CENTER);
          Thread.sleep(MusicPlayerNames.WAIT_LONG_TIME);
          inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
          inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);       
        } 
      }catch (Exception e){
          Log.v(TAG, e.toString());
      }
      inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
    
      //Verification: check if it is in low memory
      ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
      ((ActivityManager)getActivity().getSystemService("activity")).getMemoryInfo(mi);
      assertFalse(TAG, mi.lowMemory); 
     
   
  }

