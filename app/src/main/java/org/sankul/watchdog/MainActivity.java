/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sankul.watchdog;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();                                            // Add Icon to title bar
        Objects.requireNonNull(actionBar).setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_app_launcher);






        // Find the View that shows the Bonjour category
        TextView bonjour = (TextView) findViewById(R.id.bonjour);

        // Set a click listener on that View
        bonjour.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the bonjour category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link BonjourActivity}
                Intent bonjourIntent = new Intent(MainActivity.this, BonjourActivity.class);

                // Start the new activity
                startActivity(bonjourIntent);
            }
        });

        // Find the View that shows the mqtt category
        TextView mqtt = (TextView) findViewById(R.id.mqtt);

        // Set a click listener on that View
        mqtt.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the mqtt category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ClientConnections}
                Intent mqttIntent = new Intent(MainActivity.this, MqttActivity.class);

                // Start the new activity
                startActivity(mqttIntent);
            }
        });

        // Find the View that shows the numbers category
        TextView numbers = (TextView) findViewById(R.id.numbers);

        // Set a click listener on that View
        numbers.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });

    }   // end of void onCreate()
}   // end of class MainActivity



/*


In NumbersClickListener.java file:

package org.sankul.watchdog;

import android.view.View;
import android.widget.Toast;

public class NumbersClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Open the list of numbers", Toast.LENGTH_SHORT).show();
    }
}

In MainActivity.java file:
    NumbersClickListener clickListener = new NumbersClickListener();
    // Find the View that shows the numbers category
    TextView numbers = (TextView)findViewById(R.id.numbers);
    // Set a click listener on that View
     numbers.setOnClickListener(clickListener);

Shortcut to the above is to modify the MainActivity.java file as follows:
    import android.widget.Toast;

        // Find the View that shows the numbers category
        TextView numbers = (TextView) findViewById(R.id.numbers);
        // Set a click listener on that View
        numbers.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View view){
            Toast.makeText(view.getContext(), "Open the list of numbers", Toast.LENGTH_SHORT).show();
        }
    });

    buttonView.setOnClickListener (clickListener);

    public void OpenBonjourApp(View view) {
        Intent i1 = new Intent(this, BonjourActivity.class);
        startActivity(i1);
    }

    public void OpenMqttApp(View view) {
        Intent i2 = new Intent(this, MqttActivity.class);
        startActivity(i2);
    }

    public void OpenExitView(View view) {
        Intent i3 = new Intent(this, ExitActivity.class);
        startActivity(i3);
    }
*/
