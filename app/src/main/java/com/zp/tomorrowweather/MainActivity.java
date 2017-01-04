package com.zp.tomorrowweather;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zp.tomorrowweather.weatherapi.HttpUtils;
import com.zp.tomorrowweather.weatherapi.apibean.HeWeather2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements BDLocationListener {

    public LocationClient mLocationClient;

    @BindView(R.id.postion)
    TextView postion;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.bing)
    ImageView bing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(this);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Glide.with(this)
                .load("http://files.heweather.com/cond_icon/502.png")
                .into(bing);

        //Android 6.0 加入的运行时的权限
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this, permissions, 1);
        } else {
            requestLocation();
        }


    }

    private void requestLocation() {
        initLocation();
        mLocationClient.start();
    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
//        option.setScanSpan(5000);
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast("必须同意所有权限才能使用");
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast("发生未知错误");
                    finish();
                }
                break;
            default:

        }

    }

    public void Toast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {

        StringBuilder currentPosition = new StringBuilder();
        currentPosition.append("维度：").append(bdLocation.getLatitude()).append("\n");

        currentPosition.append("经度：").append(bdLocation.getLongitude()).append("\n");
        currentPosition.append("定位方式：");

        if (bdLocation.getLocType() == BDLocation.TypeGpsLocation) {
            currentPosition.append("GPS");
        } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
            currentPosition.append("NetWork");
        }

        currentPosition.append("country:").append(bdLocation.getCountry()).append("\n");
        currentPosition.append("city").append(bdLocation.getCity()).append("\n");
        currentPosition.append("province:").append(bdLocation.getProvince()).append("\n");
        currentPosition.append("cityCode:").append(bdLocation.getCityCode()).append("\n");
        currentPosition.append("district").append(bdLocation.getDistrict()).append("\n");
        currentPosition.append("street").append(bdLocation.getStreet()).append("\n");

        postion.setText(currentPosition);
        sendRequest(bdLocation.getCity());
    }

    public static String BASEURL = "https://free-api.heweather.com/v5/now";
    public static String APIKEY = "3db248d2deb14a27ac9cc8bdbcba6045";

    public void sendRequest(String address) {

        //  太原市  --》 太原
        String st = address.substring(0, address.length() - 1);

        HttpUtils httpUtils = new HttpUtils();
        httpUtils.WeatherRequest(HttpUtils.REQUEST_TYPE.NOW, st, APIKEY, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Gson gson = new Gson();
                final HeWeather2 nowWeather = gson.fromJson(response.body().string(), HeWeather2.class);
//                String str = response.body().string();
//                Log.v("tag",str);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        content.setText(nowWeather.getHeWeather5().get(0).getNow().getCond().getTxt());
                    }
                });
            }
        });




//        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new StethoInterceptor()).build();
//
////        RequestBody body = new FormBody.Builder().add("city", address).add("key", APIKEY).add("lang",).build();
//
//        String url = BASEURL + "?city=" + address + "&key=3db248d2deb14a27ac9cc8bdbcba6045";
//
//        String st = address.substring(0, address.length() - 1);
//
//        Log.v("tag", st);
//        String u = "https://free-api.heweather.com/v5/now?city=" + st + "&key=3db248d2deb14a27ac9cc8bdbcba6045";
//        Request request = new Request.Builder().url(u).build();
//
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onResponse(Call call, final Response response) throws IOException {
//                Gson gson = new Gson();
//                final HeWeather2 nowWeather = gson.fromJson(response.body().string(), HeWeather2.class);
////                String str = response.body().string();
////                Log.v("tag",str);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        content.setText(nowWeather.getHeWeather5().get(0).getNow().getCond().getTxt());
//                    }
//                });
//            }
//        });
    }


}
