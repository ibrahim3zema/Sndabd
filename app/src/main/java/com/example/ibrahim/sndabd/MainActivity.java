package com.example.ibrahim.sndabd;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // hna b2ol n l activity java da y3rd activity_main.xml k wgha leh
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        TextView textView = (TextView) findViewById(R.id.textView);
        // hna na ba5od l array l 3mltha f String.xml
        String[] item = getResources().getStringArray(R.array.index);
        // da l adapter l h7ot feh l array 3l4an a3rdh f listview
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.row_itme, R.id.textView2, item);
        // hna b7ot l adapter fl listview
        listView.setAdapter(arrayAdapter);

        // hna n b7ot no3 ll 5t bta3 l app
        /*Typeface typeface = Typeface.createFromAsset(getAssets(), "font.otf");
        textView.setTypeface(typeface);*/

        // hna 3l4an lma ados 3la item mn l listview a2dr a3ml action
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // hna b3nl intent 3l4an at7rk mn acivity ll tane
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                // w na bt7rk hn2l data bl putExtra , hn2l l position mkan ma d8t y3ne rwo 1 , 2 , 3 ......
                // "page" de l ket=y l h2dr ageb beh l data l 3ayz an2lha
                intent.putExtra("page", position);
                // bbd2
                startActivity(intent);
            }
        });


    }
    // hna bf3l zorar l share fl app bta3e
    public void shareapp(View view) {
        // zay masln a3mlo share hy2ole t5tar whats , messenger .... w ab3t l msg l t7t wl link w kda
        String txtshare = "حكايات سندباد";
        String sharlink = "https://play.google.com/store/apps/details?id=com.nirmeen.sndbad";
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, txtshare + "\n" + sharlink);
        startActivity(share);

    }
// hna b3ml intent 3l4an aft7 link l hwa t7t da
    public void moreapp(View view) {
        Intent moreappp = new Intent(Intent.ACTION_VIEW);
        moreappp.setData(Uri.parse("https://play.google.com/store/apps/details?id=nerminD"));

        startActivity(moreappp);

    }
// bardo intent 3l4an ab3t mail lma ados 3la l zorar hft7 3ndk w y2olk t5tat l gmail wla hotmail wla a myb3t l txt ll mail l nta katbo
    public void emailapp(View view) {
        String txt = "hello guys";
        Intent sendemail = new Intent(Intent.ACTION_SEND);
        sendemail.setData(Uri.parse("mailto"));
        sendemail.setType("message/rfc822");
        sendemail.putExtra(Intent.EXTRA_EMAIL, "nermin.diaa@outlook.com");
        sendemail.putExtra(Intent.EXTRA_SUBJECT, "7kayat sndbad");
        sendemail.putExtra(Intent.EXTRA_TEXT, txt);
        startActivity(sendemail);
    }
// b2fl :D
    public void closeapp(View view) {
        finish();
    }
}