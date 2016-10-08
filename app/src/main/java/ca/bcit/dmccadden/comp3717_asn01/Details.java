package ca.bcit.dmccadden.comp3717_asn01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends Activity {

    TextView tvTitle;
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Mapping with your XML view
        tvTitle = (TextView) findViewById(R.id.detailTitle);
        tvContent = (TextView) findViewById(R.id.detailContent);


        Bundle b = getIntent().getExtras();
        String course = b.getString("course", null);


        int resId = getResources().getIdentifier(course, "array",  getPackageName());
        String[] testArray = getResources().getStringArray(resId);

        tvTitle.setText(testArray[0]);
        tvContent.setText(testArray[1]);
    }
}
