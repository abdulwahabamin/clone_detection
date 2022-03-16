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
            	   } else if (mState == STATE_CREATE_SHORTCUT) {
            		   String filename = clickedFile.getName();
            		   Intent shortcutIntent = new Intent(Intent.ACTION_VIEW);
            		   shortcutIntent.setFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            		   Uri data = FileUtils.getUri(clickedFile);
            		   String type = mMimeTypes.getMimeType(filename);
            		   shortcutIntent.setDataAndType(data, type);
            		   Intent intent = new Intent();
            		   BitmapDrawable bd = (BitmapDrawable) text.getIcon();
            		   intent.putExtra(Intent.EXTRA_SHORTCUT_ICON,  bd.getBitmap());
            		   intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
            		   intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, filename);
            		   setResult(RESULT_OK, intent);
            		   finish();
            		   return;
            	   }
                    browseTo(clickedFile);
               }
          /*
          } 
          */
     }

