package com.rockin.easybox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SubmitPhoneNumberActivity extends AppCompatActivity {

    Spinner countries_spinner;
    EditText telephone_code, phone_number;
    ArrayList<TelephoneCodeSpinnerItem> telephone_code_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_phone_number);

        telephone_code = (EditText) findViewById(R.id.telephone_code_edittext);
        phone_number = (EditText) findViewById(R.id.phone_number_edittext);
        countries_spinner = (Spinner) findViewById(R.id.countries_spinner);

        initializeTelephone_code_array();

        countries_spinner.setAdapter(new TelephoneCodeSpinnerAdapter(this,
                telephone_code_array));

        /*countries_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position < CountriesAndTelephoneCodes.telephone_codes.length) {
                    telephone_code.setText(CountriesAndTelephoneCodes.telephone_codes[position]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        TextWatcher telephone_code_text_watcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {

                int countries_spinner_position;
                countries_spinner_position = CountriesAndTelephoneCodes.find_telephone_code_index(
                        telephone_code.getText().toString().trim()
                );

                if(countries_spinner_position == -1)
                    countries_spinner_position = CountriesAndTelephoneCodes.countries.length - 1;
                countries_spinner.setSelection(countries_spinner_position);

                telephone_code.setSelection(telephone_code.getText().length());
            }
        };

        telephone_code.addTextChangedListener(telephone_code_text_watcher);*/

    }

    public class TelephoneCodeSpinnerItem {

        private String actual_country_name, english_country_name, country_flag, telephone_code;

        public TelephoneCodeSpinnerItem(String actual_country_name, String english_country_name, String country_flag, String telephone_code) {
            this.actual_country_name = actual_country_name;
            this.english_country_name = english_country_name;
            this.telephone_code = telephone_code;
            this.country_flag = country_flag;
        }

        public String getActual_country_name() {
            return actual_country_name;
        }

        public String getEnglish_country_name() {
            return english_country_name;
        }

        public String getTelephone_code() {
            return telephone_code;
        }

        public String getCountry_flag() {
            return country_flag;
        }

    }

    public class TelephoneCodeSpinnerAdapter extends ArrayAdapter<TelephoneCodeSpinnerItem>{

        public TelephoneCodeSpinnerAdapter(Context context, ArrayList<TelephoneCodeSpinnerItem> telephone_code_list) {
            super(context, 0, telephone_code_list);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if(convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(
                        R.layout.telephone_code_spinner_item_off, parent, false
                );

                TelephoneCodeSpinnerItem telephoneCodeSpinnerItem = getItem(position);

                if(telephoneCodeSpinnerItem != null) {
                    ((TextView) convertView.findViewById(R.id.actual_country_name)).setText(
                            telephoneCodeSpinnerItem.getActual_country_name()
                    );
                    int country_flag_id = getResources().getIdentifier(
                            telephoneCodeSpinnerItem.getCountry_flag(), "drawable",  getPackageName());
                    ((ImageView) convertView.findViewById(R.id.country_flag)).setImageResource(
                            country_flag_id
                    );
                }
            }

            return convertView;
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            TelephoneCodeSpinnerItem telephoneCodeSpinnerItem = getItem(position);
            String telephone_code_spinner_log_tag = "TCSLT";

            if(convertView == null && telephoneCodeSpinnerItem != null) {
                if(telephoneCodeSpinnerItem.getEnglish_country_name().isEmpty()){
                    convertView = LayoutInflater.from(getContext()).inflate(
                            R.layout.telephone_code_spinner_item_on_2, parent, false
                    );
                }
                else {
                    convertView = LayoutInflater.from(getContext()).inflate(
                            R.layout.telephone_code_spinner_item_on, parent, false
                    );
                }
            }



            try {

                ((TextView) convertView.findViewById(R.id.actual_country_name)).setText(
                        telephoneCodeSpinnerItem.getActual_country_name()
                );
                if(!(telephoneCodeSpinnerItem.getEnglish_country_name().isEmpty())) {
                    ((TextView) convertView.findViewById(R.id.english_country_name)).setText(
                            telephoneCodeSpinnerItem.getEnglish_country_name()
                    );
                }
                int country_flag_id = getResources().getIdentifier(
                        telephoneCodeSpinnerItem.getCountry_flag(), "drawable",  getPackageName());
                ((ImageView) convertView.findViewById(R.id.country_flag)).setImageResource(
                        country_flag_id
                );
                String telePhone_code_temp = "+"+telephoneCodeSpinnerItem.getTelephone_code();
                ((TextView) convertView.findViewById(R.id.telephone_code)).setText(telePhone_code_temp);
            }catch (NullPointerException npe){
                Log.e(telephone_code_spinner_log_tag, "NullPointer in ipinner item");
            }

            return convertView;
        }

    }

    public void submit_button_clicked(View view){

    }

    private void initializeTelephone_code_array() {

        final String telephone_code_json_file_log_tag = "TCJFLT";
        String telephone_code_json_file;
        telephone_code_array = new ArrayList<>();

        try {

            InputStream inputStream = getAssets().open("telephone_code_json_file.json");
            byte inputStreamBuffer[] = new byte[inputStream.available()];
            inputStream.read(inputStreamBuffer);
            inputStream.close();

            telephone_code_json_file = new String(inputStreamBuffer, "UTF-8");
            JSONArray telephone_code_json_array = new JSONArray(telephone_code_json_file);

            for (int i = 0; i < telephone_code_json_array.length(); i++) {

                JSONObject jsonObject = telephone_code_json_array.getJSONObject(i);
                TelephoneCodeSpinnerItem telephoneCodeSpinnerItem;

                if (jsonObject.get("english_country_name").equals("")) {
                    telephoneCodeSpinnerItem = new TelephoneCodeSpinnerItem(
                            jsonObject.getString("actual_country_name"),
                            "",
                            jsonObject.getString("country_flag"),
                            jsonObject.getString("telephone_code")
                    );
                }
                else {
                    telephoneCodeSpinnerItem = new TelephoneCodeSpinnerItem(
                            jsonObject.getString("actual_country_name"),
                            jsonObject.getString("english_country_name"),
                            jsonObject.getString("country_flag"),
                            jsonObject.getString("telephone_code")
                    );
                }

                telephone_code_array.add(telephoneCodeSpinnerItem);

            }
        } catch (IOException e1) {
            Log.e(telephone_code_json_file_log_tag, "telephone_code_json_file could not open", e1);
        } catch (JSONException e2) {
            Log.e(telephone_code_json_file_log_tag, "JSONArray got the error", e2);
        }
    }
}


























