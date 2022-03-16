    private void spaceHeightWidth(){
        minTemp= getMinTemperature(mLowTemp);
        maxTemp= getMaxTemperature(mTopTemp);
        int h= maxTemp-minTemp;
        mSpace=4*(viewHeight-60*pxScale/3)/(5*h);
        
        if(mLowTemp.size()==7){
            dx7[0]=viewWidth/14;
            dx7[1]=viewWidth*3/14;
            dx7[2]=viewWidth*5/14;
            dx7[3]=viewWidth*7/14;
            dx7[4]=viewWidth*9/14;
            dx7[5]=viewWidth*11/14;
            dx7[6]=viewWidth*13/14;

            tmpArray=dx7;
        }
        else if(mLowTemp.size()==8) {
            dx8[0] = viewWidth / 16;
            dx8[1] = viewWidth * 3 / 16;
            dx8[2] = viewWidth * 5 / 16;
            dx8[3] = viewWidth * 7 / 16;
            dx8[4] = viewWidth * 9 / 16;
            dx8[5] = viewWidth * 11 / 16;
            dx8[6] = viewWidth * 13 / 16;
            dx8[7] = viewWidth * 15 / 16;

            tmpArray=dx8;
        }
        
    }

