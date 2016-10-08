package ca.bcit.dmccadden.comp3717_asn01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class Courses extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        listView = (ListView) findViewById(R.id.courseList);

        Bundle b = getIntent().getExtras();
        String term = b.getString("term", null);

        int resId = getResources().getIdentifier(term, "array",  getPackageName());

        /// Getting list of Strings from your resource
        String[] testArray = getResources().getStringArray(resId);
        List<String> courseList = Arrays.asList(testArray);

        //Instanciating Adapter
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(getBaseContext(),
                android.R.layout.simple_list_item_1,
                courseList);

        // setting adapter on listview
        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Object o = listView.getItemAtPosition(position);
                String itemName = (String) arg0.getItemAtPosition(position);
                Intent i = new Intent(Courses.this, Details.class);
                i.putExtra("course", itemName);
                startActivity(i);
            }
        });
    }
}
