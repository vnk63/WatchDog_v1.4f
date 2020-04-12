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

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

public class NumbersActivity extends AppCompatActivity {
    private PahoMqttClient pahoMqttClient;
//    private String msg_new = "";
//    private tvMessage = "";
    TextView tvMessage = (TextView) findViewById(R.id.subscribedMsg);
    EditText etSubTopicSn = (EditText) findViewById(R.id.subTop2);
    EditText etSubTopicSw = (EditText) findViewById(R.id.subTopic);
    EditText etPubTopic = (EditText) findViewById(R.id.pubTopic);
    EditText etPubMsg = (EditText) findViewById(R.id.pubMsg);
    EditText etBroker = (EditText) findViewById(R.id.urlBroker);
    EditText etUName = (EditText) findViewById(R.id.clientUn);
    EditText etPWord = (EditText) findViewById(R.id.clientPw);
    String msg_new = "";
    private MqttAndroidClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        ActionBar actionBar = getSupportActionBar();                                            // Add Icon to title bar
        Objects.requireNonNull(actionBar).setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_app_launcher);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggle);
        TextView toglTextOff = (TextView) findViewById(R.id.toggleTextViewOff);
        TextView toglTextOn = (TextView) findViewById(R.id.toggleTextViewOn);
        ImageView mNotification_on_indic=(ImageView)findViewById(R.id.on_indicator);
        ImageView mNotification_off_indic=(ImageView)findViewById(R.id.off_indicator);

        MqSetActivity mq2 = new MqSetActivity();
//        System.out.println(mq2.getPahoMqttClient());
        pahoMqttClient = mq2.getPahoMqttClient();

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
//                    //Check if connected to broker
//                    if (!pahoMqttClient.mqttAndroidClient.isConnected()) {
//                        msg_new = "Currently not connected to MQTT broker: Must be connected to publish message to a topic\r\n";
//                        tvMessage.append(msg_new);
//                    }
//                    else {
//                        //Publish non-blank message
//                        String pubtopic = etPubTopic.getText().toString().trim();
//                        String msg = etPubMsg.getText().toString().trim();
//                        if (!msg.isEmpty()) {
//                            try {
//                                pahoMqttClient.publishMessage(client, "1", 1, pubtopic);
//                                msg_new = "Message sent to pub topic: " + etPubTopic.getText() + "\r\n";
//                                tvMessage.append(msg_new);
//                            } catch (MqttException | UnsupportedEncodingException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//


                    toglTextOn.setVisibility(View.INVISIBLE);
                    toglTextOff.setVisibility(View.VISIBLE);
                    mNotification_on_indic.setVisibility(View.GONE);
                    mNotification_off_indic.setVisibility(View.VISIBLE);
                }
                else
                {

//                    //Check if connected to broker
//                    if (!pahoMqttClient.mqttAndroidClient.isConnected()) {
//                        msg_new = "Currently not connected to MQTT broker: Must be connected to publish message to a topic\r\n";
//                        tvMessage.append(msg_new);
//                    }
//                    else {
//                        //Publish non-blank message
//                        String pubtopic = etPubTopic.getText().toString().trim();
//                        String msg = etPubMsg.getText().toString().trim();
//                        if (!msg.isEmpty()) {
//                            try {
//                                pahoMqttClient.publishMessage(client, "0", 1, pubtopic);
//                                msg_new = "Message sent to pub topic: " + etPubTopic.getText() + "\r\n";
//                                tvMessage.append(msg_new);
//                            } catch (MqttException | UnsupportedEncodingException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//



                    toglTextOff.setVisibility(View.INVISIBLE);
                    toglTextOn.setVisibility(View.VISIBLE);
                    mNotification_off_indic.setVisibility(View.GONE);
                    mNotification_on_indic.setVisibility(View.VISIBLE);
                }

            }
        });


//        pahoMqttClient = new PahoMqttClient();
//        client = pahoMqttClient.getMqttClient(getApplicationContext(),                        // Connect to MQTT Broker
//                urlBroker,
//                clientid,
//                username,
//                password
//        );



/*        mNotification_on_indic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNotification_on_indic.setVisibility(View.GONE);
                mNotification_off_indic.setVisibility(View.VISIBLE);
            }
        });
        mNotification_off_indic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNotification_off_indic.setVisibility(View.GONE);
                mNotification_on_indic.setVisibility(View.VISIBLE);
            }
        });
*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.numbers_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            Intent intent = new Intent(this, MqSetActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }



}
