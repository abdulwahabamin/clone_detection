     /** @param convertView The old view to overwrite, if one is passed 
      * @returns a IconifiedTextView that holds wraps around an IconifiedText */ 
     public View getView(int position, View convertView, ViewGroup parent) { 
          IconifiedTextView btv; 
          if (convertView == null) { 
               btv = new IconifiedTextView(mContext, mItems.get(position)); 
          } else { // Reuse/Overwrite the View passed 
               // We are assuming(!) that it is castable! 
               btv = (IconifiedTextView) convertView; 
          } 
          btv.setText(mItems.get(position).getText()); 
          btv.setInfo(mItems.get(position).getInfo()); 
          btv.setIcon(mItems.get(position).getIcon()); 
          return btv; 
     }

