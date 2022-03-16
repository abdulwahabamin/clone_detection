	  public static void initVisualizer( MediaPlayer player ){
		  VisualizerUtils.releaseVisualizer();
		  try{
			  mVisualizer =  new Visualizer(player.getAudioSessionId());
		  }
		  catch(Exception e){
			  mVisualizer = null;
			  return;
		  }

		  mVisualizer.setEnabled(false);		  

		  mVisualizer.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);

		  Visualizer.OnDataCaptureListener captureListener = new Visualizer.OnDataCaptureListener()
		  {
			  @Override
			  public void onWaveFormDataCapture(Visualizer visualizer, byte[] bytes,
			      int samplingRate)
			  {
				  VisualizerUtils.updateVisualizer(bytes);
			  }
			
			  @Override
			  public void onFftDataCapture(Visualizer visualizer, byte[] bytes,
			      int samplingRate)
			  {
				  VisualizerUtils.updateVisualizerFFT(bytes);
			  }
		  };
		  mVisualizer.setDataCaptureListener(captureListener,20000 , true, true);	

		  mVisualizer.setEnabled(true);		  
	  }

