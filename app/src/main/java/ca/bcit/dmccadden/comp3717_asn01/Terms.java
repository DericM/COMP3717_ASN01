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

import static ca.bcit.dmccadden.comp3717_asn01.R.layout.activity_terms;


public class Terms extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_terms);

        listView = (ListView) findViewById(R.id.termsList);

        /// Getting list of Strings from your resource
        String[] testArray = getResources().getStringArray(R.array.terms);
        List<String> termsList = Arrays.asList(testArray);

        // Instanciating Adapter
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(getBaseContext(),
                android.R.layout.simple_list_item_1,
                termsList);

        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Object o = listView.getItemAtPosition(position);
                String itemName = (String) arg0.getItemAtPosition(position);
                Intent i = new Intent(Terms.this, Courses.class);
                i.putExtra("term", itemName);
                startActivity(i);
            }
        });


    }
}
