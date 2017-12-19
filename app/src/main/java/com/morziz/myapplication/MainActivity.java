package com.morziz.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private ImageLoader imageLoader;
    String url = "https://i.pinimg.com/736x/3b/f3/1a/3bf31abc7a7a95f381b21a1d8a7ad10f--charlotte-rampling-rose-flower.jpg";
    Bitmap loadedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         imageLoader = ImageLoader.getInstance();
         imageView=findViewById(R.id.image);


        ImageLoader imageLoader = ImageLoader.getInstance();
       /* DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(R.drawable.map)
                .showImageOnFail(R.drawable.map)
                .showImageOnLoading(R.drawable.map).build();
        imageLoader.displayImage(url, imageView, options);

     */

        imageLoader.loadImage(url, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImagee) {
                loadedImage=loadedImagee;
                imageView.setImageBitmap(loadedImagee);
            }
        });

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String packageName = "com.facebook.katana";
                String fullUrl = "https://m.facebook.com/sharer.php?u=..";

                Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
                if (intent == null) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(fullUrl));
                    startActivity(i);
                } else {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setClassName(packageName ,
                            "com.facebook.katana.ShareLinkActivity");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, "your title text");
                    startActivity(sharingIntent);
                }












//------------------------All Share-------------------------------------
             /*   try {
                    File file = new File(getApplicationContext().getExternalCacheDir(),"logicchip.png");
                    FileOutputStream fOut = new FileOutputStream(file);
                    loadedImage.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                    fOut.flush();
                    fOut.close();
                    file.setReadable(true, false);
                    final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                    intent.setType("image/png");
                    startActivity(Intent.createChooser(intent, "Share image via"));
                } catch (Exception e) {
                    e.printStackTrace();
                }*/
                //-----------------------------------------------------
            }
        });
    }
}