package com.example.pch.projectdrum;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class MyView extends View {
    String TAG;
    Paint paint;
    int id[] = new int[5];
    int arr_x[] = new int[5];
    int arr_y[] = new int[5];
    boolean isPushed[] = {false, false, false, false, false, false, false, false};
    boolean isMoveIn[] = {false, false, false, false, false, false, false, false};
    Bitmap drum1, drum2, drum3, drum4, drum5, drum6, drum7, drum8;


    float width;
    float height;

    float drumWidth;
    float drumHeight;

    HitTest hitTest;
    Region region1, region2, region3, region4, region5, region6, region7, region8;
    Region arr_region[];
    int count;

    float drum1_x, drum1_y;
    float drum2_x, drum2_y;
    float drum3_x, drum3_y;
    float drum4_x, drum4_y;
    float drum5_x, drum5_y;
    float drum6_x, drum6_y;
    float drum7_x, drum7_y;
    float drum8_x, drum8_y;

    boolean flag = false;

    private final int SACLE = 2;
    private final int WANT_HEIGHT = 300;

    MainActivity mainActivity;

    public MyView(Context context, MainActivity mainActivity) {
        super(context);
        this.mainActivity = mainActivity;
        TAG = this.getClass().getName();
        DisplayMetrics display = mainActivity.getResources().getDisplayMetrics();

        hitTest = new HitTest();

        width = display.widthPixels;
        height = display.heightPixels;


        Log.d(TAG, "width 는" + width + " , height 는" + height);


        init();

    }


    public void init() {


        paint = new Paint();

        this.setBackgroundColor(Color.WHITE);

        drum1 = BitmapFactory.decodeResource(getResources(), R.drawable.bt);
        drumWidth = drum1.getWidth();
        drumHeight = drum1.getHeight();

        if (drumHeight <= WANT_HEIGHT) {
            float percent = (drumHeight / 100);
            float scale = (WANT_HEIGHT / percent);
            drumWidth *= (scale/100);
            drumHeight *= (scale/100);
        }
        drum1 = Bitmap.createScaledBitmap(drum1, (int) drumWidth, (int) drumHeight, true);
        drum1_x = width * (0.5f) - drum1.getWidth() / 2;
        drum1_y = height * (0.5f) + drum1.getHeight() / 2;
        region1 = new Region();
        region1 = hitTest.getBitmapRegion(drum1, (int) drum1_x, (int) drum1_y);

        drum2 = BitmapFactory.decodeResource(getResources(), R.drawable.bt);
        drumWidth = drum2.getWidth();
        drumHeight = drum2.getHeight();

        if (drumHeight <= WANT_HEIGHT) {
            float percent = (drumHeight / 100);
            float scale = (WANT_HEIGHT / percent);
            drumWidth *= (scale/100);
            drumHeight *= (scale/100);
        }
        drum2 = Bitmap.createScaledBitmap(drum2, (int) drumWidth, (int) drumHeight, true);
        drum2_x = width * (0.4f) - drum2.getWidth() / 2;
        drum2_y = height * (0.42f);
        region2 = new Region();
        region2 = hitTest.getBitmapRegion(drum2, (int) drum2_x, (int) drum2_y);

        drum3 = BitmapFactory.decodeResource(getResources(), R.drawable.bt);
        drumWidth = drum3.getWidth();
        drumHeight = drum3.getHeight();

        if (drumHeight <= WANT_HEIGHT) {
            float percent = (drumHeight / 100);
            float scale = (WANT_HEIGHT / percent);
            drumWidth *= (scale/100);
            drumHeight *= (scale/100);
        }
        drum3 = Bitmap.createScaledBitmap(drum3, (int) drumWidth, (int) drumHeight, true);
        drum3_x = width * (0.6f) - drum3.getWidth() / 2;
        drum3_y = height * (0.42f);
        region3 = new Region();
        region3 = hitTest.getBitmapRegion(drum3, (int) drum3_x, (int) drum3_y);

        drum4 = BitmapFactory.decodeResource(getResources(), R.drawable.bt);
        drumWidth = drum4.getWidth();
        drumHeight = drum4.getHeight();

        if (drumHeight <= WANT_HEIGHT) {
            float percent = (drumHeight / 100);
            float scale = (WANT_HEIGHT / percent);
            drumWidth *= (scale/100);
            drumHeight *= (scale/100);
        }
        drum4 = Bitmap.createScaledBitmap(drum4, (int) drumWidth, (int) drumHeight, true);
        drum4_x = width * (0.58f) - drum4.getWidth() / 2;
        drum4_y = height * (0.1f);
        region4 = new Region();
        region4 = hitTest.getBitmapRegion(drum4, (int) drum4_x, (int) drum4_y);

        drum5 = BitmapFactory.decodeResource(getResources(), R.drawable.bt);
        drumWidth = drum5.getWidth();
        drumHeight = drum5.getHeight();

        if (drumHeight <= WANT_HEIGHT) {
            float percent = (drumHeight / 100);
            float scale = (WANT_HEIGHT / percent);
            drumWidth *= (scale/100);
            drumHeight *= (scale/100);
        }
        drum5 = Bitmap.createScaledBitmap(drum5, (int) drumWidth, (int) drumHeight, true);
        drum5_x = width * (0.42f) - drum5.getWidth() / 2;
        drum5_y = height * (0.1f);
        region5 = new Region();
        region5 = hitTest.getBitmapRegion(drum5, (int) drum5_x, (int) drum5_y);

        drum6 = BitmapFactory.decodeResource(getResources(), R.drawable.bt);
        drumWidth = drum6.getWidth();
        drumHeight = drum6.getHeight();

        if (drumHeight <= WANT_HEIGHT) {
            float percent = (drumHeight / 100);
            float scale = (WANT_HEIGHT / percent);
            drumWidth *= (scale/100);
            drumHeight *= (scale/100);
        }
        drum6 = Bitmap.createScaledBitmap(drum6, (int) drumWidth, (int) drumHeight, true);
        drum6_x = width * (0.2f) - drum6.getWidth() / 2;
        drum6_y = height * (0.03f);
        region6 = new Region();
        region6 = hitTest.getBitmapRegion(drum6, (int) drum6_x, (int) drum6_y);

        drum7 = BitmapFactory.decodeResource(getResources(), R.drawable.bt);
        drumWidth = drum7.getWidth();
        drumHeight = drum7.getHeight();

        if (drumHeight <= WANT_HEIGHT) {
            float percent = (drumHeight / 100);
            float scale = (WANT_HEIGHT / percent);
            drumWidth *= (scale/100);
            drumHeight *= (scale/100);
        }
        drum7 = Bitmap.createScaledBitmap(drum7, (int) drumWidth, (int) drumHeight, true);
        drum7_x = width * (0.8f) - drum7.getWidth() / 2;
        drum7_y = height * (0.03f);
        region7 = new Region();
        region7 = hitTest.getBitmapRegion(drum7, (int) drum7_x, (int) drum7_y);

        drum8 = BitmapFactory.decodeResource(getResources(), R.drawable.bt);
        drumWidth = drum8.getWidth();
        drumHeight = drum8.getHeight();

        if (drumHeight <= WANT_HEIGHT) {
            float percent = (drumHeight / 100);
            float scale = (WANT_HEIGHT / percent);
            drumWidth *= (scale/100);
            drumHeight *= (scale/100);
        }
        drum8 = Bitmap.createScaledBitmap(drum8, (int) drumWidth, (int) drumHeight, true);
        drum8_x = width * (0.15f) - drum8.getWidth() / 2;
        drum8_y = height * (0.3f);
        region8 = new Region();
        region8 = hitTest.getBitmapRegion(drum8, (int) drum8_x, (int) drum8_y);

        arr_region = new Region[]{region1, region2, region3, region4, region5, region6, region7, region8};

    }

    @Override
    protected void onDraw(Canvas canvas) {
        /*Log.d( TAG, "높이 : "+height+", 넓이 : "+width);*/


        paint = new Paint();
        canvas.drawBitmap(drum1, width * (0.5f) - drum1.getWidth() / 2, height * (0.5f) + drum1.getHeight() / 2, null);
        canvas.drawBitmap(drum2, width * (0.4f) - drum2.getWidth() / 2, height * (0.42f), null);
        canvas.drawBitmap(drum3, width * (0.6f) - drum3.getWidth() / 2, height * (0.42f), null);
        canvas.drawBitmap(drum4, width * (0.58f) - drum4.getWidth() / 2, height * (0.1f), null);
        canvas.drawBitmap(drum5, width * (0.42f) - drum5.getWidth() / 2, height * (0.1f), null);
        canvas.drawBitmap(drum6, width * (0.2f) - drum6.getWidth() / 2, height * (0.03f), null);
        canvas.drawBitmap(drum7, width * (0.8f) - drum7.getWidth() / 2, height * (0.03f), null);
        canvas.drawBitmap(drum8, width * (0.15f) - drum8.getWidth() / 2, height * (0.3f), null);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int pointer_count = event.getPointerCount(); //현재 터치 발생한 포인트 수를 얻는다
        if (pointer_count > 3) pointer_count = 3; //5개 이상의 포인트를 터치했더라도 5개까지만 처리를 한다.
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:


            case MotionEvent.ACTION_POINTER_DOWN:
                for (int i = 0; i < pointer_count; i++) {
                    {
                        arr_x[i] = (int) (event.getX(i));
                        arr_y[i] = (int) (event.getY(i));

                        if (hitTest.isHit(arr_x[i], arr_y[i], region1) && isPushed[0] == false && isMoveIn[0]==false) {
                            Log.d(TAG, i + "번째 손가락이 1번 닿았다");
                            isPushed[0] = true;
                            continue;
                        } else if (hitTest.isHit(arr_x[i], arr_y[i], region2) && isPushed[1] == false&& isMoveIn[1]==false) {
                            count++;

                            Log.d(TAG, i + "번째 손가락이 2번 닿았다");
                            isPushed[1] = true;
                            continue;
                        } else if (hitTest.isHit(arr_x[i], arr_y[i], region3) && isPushed[2] == false&& isMoveIn[2]==false) {
                            count++;
                            Log.d(TAG, i + "번째 손가락이 3번 닿았다");
                            isPushed[2] = true;
                            continue;
                        } else if (hitTest.isHit(arr_x[i], arr_y[i], region4) && isPushed[3] == false&& isMoveIn[3]==false) {
                            count++;

                            Log.d(TAG, i + "번째 손가락이 4번 닿았다");
                            isPushed[3] = true;
                            continue;
                        } else if (hitTest.isHit(arr_x[i], arr_y[i], region5) && isPushed[4] == false&& isMoveIn[4]==false) {
                            count++;

                            Log.d(TAG, i + "번째 손가락이 5번 닿았다");
                            isPushed[4] = true;
                            continue;
                        } else if (hitTest.isHit(arr_x[i], arr_y[i], region6) && isPushed[5] == false&& isMoveIn[5]==false) {
                            count++;

                            Log.d(TAG, i + "번째 손가락이 6번 닿았다");
                            isPushed[5] = true;
                            continue;
                        } else if (hitTest.isHit(arr_x[i], arr_y[i], region7) && isPushed[6] == false&& isMoveIn[6]==false) {
                            count++;

                            Log.d(TAG, i + "번째 손가락이 7번 닿았다");
                            isPushed[6] = true;
                            continue;
                        } else if (hitTest.isHit(arr_x[i], arr_y[i], region8) && isPushed[7] == false&& isMoveIn[7]==false) {
                            count++;

                            Log.d(TAG, i + "번째 손가락이 8번 닿았다");
                            isPushed[7] = true;
                            continue;
                        }

                    }
                }

            case MotionEvent.ACTION_MOVE: {
                for (int i = 0; i < arr_region.length; i++) {
                    if (hitTest.isHit(x, y, arr_region[i]) && isMoveIn[i] == false &&isPushed[i]==false) {
                        isMoveIn[i] = true;
                        count++;
                        Log.d(TAG, (i+1)+ "번 닿았다");
                    } else if (!hitTest.isHit(x, y, arr_region[i]) && isMoveIn[i] == true) {
                        isMoveIn[i] = false;
                        Log.d(TAG, (i+1) + "번 나왔다.");
                    }
                }
            }
            break;

            case MotionEvent.ACTION_UP:
                for (int i = 0; i < isPushed.length; i++) {
                    {
                        isPushed[i] = false;
                    }
                }
                break;

            case MotionEvent.ACTION_CANCEL:
                break;
            case MotionEvent.ACTION_OUTSIDE:
                break;
        }


        return true;

    }
}
