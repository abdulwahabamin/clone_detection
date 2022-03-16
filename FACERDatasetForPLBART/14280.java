	  public static void updateVisualizerFFT(byte[] bytes) {
		  if(mView==null)
			  return;
		  VisualizerView view = mView.get();
	      if (view == null) {
	      	return;
	      }
		  view.updateVisualizerFFT(bytes);
	  }

