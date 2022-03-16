     @Override 
     protected void onListItemClick(ListView l, View v, int position, long id) { 
          super.onListItemClick(l, v, position, id); 
          
          IconifiedTextListAdapter adapter = (IconifiedTextListAdapter) getListAdapter();
          
          if (adapter == null) {
        	  return;
          }
          
          IconifiedText text = (IconifiedText) adapter.getItem(position);

          if (mState == STATE_MULTI_SELECT) {
        	  text.setSelected(!text.isSelected());
        	  adapter.notifyDataSetChanged();
        	  return;
          }
			
          String file = text.getText(); 
          /*
          if (selectedFileString.equals(getString(R.string.up_one_level))) { 
               upOneLevel(); 
          } else { 
          */
        	  String curdir = currentDirectory 
              .getAbsolutePath() ;
        	  File clickedFile = FileUtils.getFile(curdir, file);
               if (clickedFile != null) {
            	   if (clickedFile.isDirectory()) {
            		   // If we click on folders, we can return later by the "back" key.
            		   mStepsBack++;
            	   }
                    browseTo(clickedFile);
               }
          /*
          } 
          */
     }

