package com.example.app;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.DecimalFormat;

    public class WeatherActivity extends AppCompatActivity {
        EditText etZip;
        TextView tvResult;
        private  String url = "http://api.openweathermap.org/data/2.5/forecast?id=524901&zip=48312&cnt=1&appid=94a4143658ad8966e26f35512cd0f006";
        private final String appID = "94a4143658ad8966e26f35512cd0f006";
        DecimalFormat df = new DecimalFormat("#.##");


        @SuppressLint({"MissingInflatedId", "WrongViewCast"})
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.weather_activity);
            etZip=findViewById(R.id.etZip);
            tvResult=findViewById(R.id.tvResult);
        }

        @SuppressLint("SetTextI18n")
        public void getWeatherDetails(View view) {
            String zip = etZip.getText().toString().trim();
            url="http://api.openweathermap.org/data/2.5/forecast?id=524901&zip="+zip+"&cnt=1&appid=94a4143658ad8966e26f35512cd0f006";
            if(zip.equals("")){
                tvResult.setText("Zip field can not be empty!");
            }
            else{
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, this::onResponse, error -> Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show());
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
            }
        }

        private void onResponse(String response) {
            String output = "";
            try {
                JSONObject jsonResponse = new JSONObject(response);
                JSONArray jsonArray = jsonResponse.getJSONArray("list");
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                String dtxt = jsonObject.getString("dt_txt");       //Date-Time
                JSONObject main = jsonObject.getJSONObject("main");
                double temp = (main.getDouble("temp")-273.15)*(9/5)+32;           //temperature
                JSONObject clouds = jsonObject.getJSONObject("clouds");
                String cloudy = clouds.getString("all");            //clouds
                JSONObject city = jsonResponse.getJSONObject("city");
                String name = city.getString("name");                   //city name
                JSONArray jsonArray1 = jsonObject.getJSONArray("weather");
                JSONObject weather = jsonArray1.getJSONObject(0);
                String conditions = weather.getString("main");      //weather conditions


                        output += "Current weather conditions of " + name + " on " + dtxt + ":\n"
                                + "Temperature: " + df.format(temp) + " °F\n"
                                + "Conditions: " + conditions + "\n"
                                + "Cloudiness: " + cloudy +"%";


//                        output += "Current weather of " + cityName + " (" + countryName + ")"
//                                + "\n Temp: " + df.format(temp) + " °C"
//                                + "\n Feels Like: " + df.format(feelsLike) + " °C"
//                                + "\n Humidity: " + humidity + "%"
//                                + "\n Description: " + description
//                                + "\n Wind Speed: " + wind + "m/s (meters per second)"
//                                + "\n Cloudiness: " + clouds + "%"
//                                + "\n Pressure: " + pressure + " hPa";
                tvResult.setText(output);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

