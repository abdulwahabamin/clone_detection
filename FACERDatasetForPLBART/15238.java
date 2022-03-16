	  public static void updateVisualizer(byte[] bytes) {
		  if(mView==null)
			  return;
		  VisualizerView view = mView.get();
	      if (view == null) {
	      	return;
	      }
		  view.updateVisualizer(bytes);
	  }

