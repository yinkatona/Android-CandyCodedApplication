package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static com.pluralsight.candycoded.DetailActivity.HASHTAG_CANDYCODED;
import static com.pluralsight.candycoded.DetailActivity.SHARE_DESCRIPTION;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    public void createMapIntent(View view){
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801"));
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null);
        startActivity(mapIntent);
    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***

    public void createPhoneIntent(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0123456789"));
        startActivity(intent);

    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        createShareIntent();
        return super.onOptionsItemSelected(item);
    }

    private void createShareIntent(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");


        shareIntent.putExtra(Intent.EXTRA_SUBJECT, HASHTAG_CANDYCODED );
        shareIntent.putExtra(Intent.EXTRA_TEXT, SHARE_DESCRIPTION);

        startActivity(shareIntent);

    }
}
